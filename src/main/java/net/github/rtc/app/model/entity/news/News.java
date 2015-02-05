package net.github.rtc.app.model.entity.news;


import net.github.rtc.app.model.entity.AbstractPersistenceObject;
import net.github.rtc.app.model.entity.activity.IActivity;
import net.github.rtc.app.model.entity.course.Tag;
import net.github.rtc.app.model.entity.user.User;
import net.github.rtc.util.annotation.ForExport;
import net.github.rtc.util.annotation.validation.Validatable;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Validatable
public class News extends AbstractPersistenceObject implements Serializable, IActivity {


    @NotEmpty
    @Column
    @ForExport("Title")
    private String title;

    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @ForExport("Publish date")
    private Date publishDate = new Date();

    @Column
    @Enumerated(EnumType.STRING)
    private NewsStatus status = NewsStatus.DRAFT;

    @NotEmpty
    @Column
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "news_tags",
            joinColumns = { @JoinColumn(name = "tagId") },
            inverseJoinColumns = { @JoinColumn(name = "id") })
    private List<Tag> tags;

    public News() {
    }

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate == null ? null : new Date(publishDate.getTime());
    }

    public void setPublishDate(final Date publishDate) {
        if (publishDate != null) {
            this.publishDate = new Date(publishDate.getTime());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate == null ? null : new Date(createDate.getTime());
    }

    public void setCreateDate(final Date createDate) {
        if (createDate != null) {
            this.createDate = new Date(createDate.getTime());
        }
    }

    public NewsStatus getStatus() {
        return status;
    }

    public void setStatus(NewsStatus status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(final List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getLogDetail()).append(createDate);
        return builder.toString();
    }

    @Override
    public String getLogDetail() {
        final StringBuilder builder = new StringBuilder();
        builder.append("News ").append("id:" + getId()).append(" title:" + getTitle());
        return builder.toString();
    }
}