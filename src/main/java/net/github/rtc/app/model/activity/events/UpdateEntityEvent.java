package net.github.rtc.app.model.activity.events;

import net.github.rtc.app.model.activity.ActivityEntity;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;

public class UpdateEntityEvent extends ApplicationEvent {

    private String details;

    private ActivityEntity entity;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public UpdateEntityEvent(Object source, String details, ActivityEntity entity) {
        super(source);
        this.details = details;
        this.entity = entity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ActivityEntity getEntity() {
        return entity;
    }

    public void setEntity(ActivityEntity entity) {
        this.entity = entity;
    }
}