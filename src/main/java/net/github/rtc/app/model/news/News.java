package net.github.rtc.app.model.news;


import net.github.rtc.app.model.AbstractPersistenceObject;
import net.github.rtc.app.model.course.Tag;
import net.github.rtc.app.model.user.User;
import net.github.rtc.util.annotation.ForExport;
import net.github.rtc.util.annotation.validation.Required;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class News extends AbstractPersistenceObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Required
    @Column
    @ForExport("Title")
    private String title;

    @OneToOne
//    @PrimaryKeyJoinColumn
    @JoinColumn(name = "author_id")
    private User author;

    @Column
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column
    @Enumerated(EnumType.STRING)
    private NewsStatus status = NewsStatus.DRAFT;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}
