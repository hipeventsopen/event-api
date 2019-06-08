package hipevents.event.domain;

public class EventListItem {
    public final String id;
    public final String name;
    public final String description;

    public EventListItem(EventItem eventItem) {
        this.id = eventItem.getId();
        this.name = eventItem.getName();
        this.description = eventItem.getDescription();
    }
}