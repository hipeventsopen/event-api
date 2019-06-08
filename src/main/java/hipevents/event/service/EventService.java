package hipevents.event.service;

import hipevents.event.domain.EventItem;
import hipevents.event.domain.EventListItem;
import hipevents.event.domain.EventItemInput;

import java.util.List;

public interface EventService {
    List<EventListItem> getEventFeed();
    EventItem getEventByID(String ID);
    void deleteEventByID(String ID);
    void createNewEvent(EventItemInput eventItemInput);
}
