package net.github.rtc.app.model.dto.filter;

import net.github.rtc.app.model.entity.course.Course;
import net.github.rtc.app.model.entity.course.CourseStatus;
import net.github.rtc.app.model.entity.course.CourseType;
import net.github.rtc.app.model.entity.course.Tag;
import org.hibernate.criterion.*;
import org.hibernate.type.StringType;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class CourseSearchFilter extends AbstractSearchFilter {

    private static final String PERCENT = "%";
    private static final String TAGS = "tags";
    private static final String START_DATE = "startDate";
    private static final String EXPERTS = "experts";
    private static final String STATUS = "status";
    private String name;
    private char dateMoreLessEq;
    private Set<CourseType> types;
    private Date startDate;
    private Set<CourseStatus> status;
    private List<Tag> tags;
    private String expertCode;
    private boolean withArchived = false;

    public char getDateMoreLessEq() {
        return dateMoreLessEq;
    }

    public void setDateMoreLessEq(char dateMoreLessEq) {
        this.dateMoreLessEq = dateMoreLessEq;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<CourseType> getTypes() {
        return types;
    }

    public void setTypes(final Set<CourseType> types) {
        this.types = types;
    }

    public Date getStartDate() {
        return startDate == null ? null : new Date(startDate.getTime());
    }

    public void setStartDate(final Date startDate) {
        if (startDate != null) {
            this.startDate = new Date(startDate.getTime());
        }
    }

    public Set<CourseStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<CourseStatus> status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(final List<Tag> tags) {
        this.tags = tags;
    }

    public String getExpertCode() {
        return expertCode;
    }

    public void setExpertCode(final String expertCode) {
        this.expertCode = expertCode;
    }

    public boolean isWithArchived() {
        return withArchived;
    }

    public void setWithArchived(boolean withArchived) {
        this.withArchived = withArchived;
        if (withArchived) {
            getStatus().add(CourseStatus.ARCHIVED);
        }
    }

    @Override
    public Order order() {
        return Order.desc("id");
    }

    public DetachedCriteria getCriteria() {
        final DetachedCriteria criteria = DetachedCriteria.forClass(Course.class);

        if (name != null && !("").equals(name)) {
            criteria.add(Restrictions.like("name", PERCENT + name + PERCENT));
        }
        if (status != null && status.size() > 0) {
            criteria.add(Restrictions.in(STATUS, status));
        }
        if (startDate != null) {
            final DateCriteriaCreator dateCriteriaCreator = new DateCriteriaCreator(START_DATE, startDate);
            criteria.add(dateCriteriaCreator.getDateCriteria(dateMoreLessEq));
        }
        if (tags != null && tags.size() > 0) {
            criteria.createAlias(TAGS, TAGS);
            final Disjunction tagDis = Restrictions.disjunction();
            for (final Tag tag : tags) {
                tagDis.add(Restrictions.eq("tags.value", tag.getValue()));
            }
            criteria.add(tagDis);
        }
        if (types != null && types.size() > 0) {
            final Conjunction typesCon = Restrictions.conjunction();
            for (final CourseType type : types) {
                typesCon.add(Restrictions.sqlRestriction(
                  "exists (select t.course_id from CourseTypes t where t.course_id = {alias}.id and t.types = ?)",
                  type.name(), new StringType()));
            }
            criteria.add(typesCon);
        }
        if (expertCode != null && !("").equals(expertCode)) {
            criteria.createAlias(EXPERTS, EXPERTS);
            final Conjunction experts = Restrictions.conjunction();
            experts.add(Restrictions.eq("experts.code", expertCode));
            criteria.add(experts);
        }
        if (withArchived) {
            criteria.addOrder(Order.desc(STATUS));
        }
        criteria.addOrder(Order.desc("createDate"));
        return criteria;
    }
}
