package hipevents.event.service;

import hipevents.event.domain.*;

import java.util.List;

public interface EventService {
    List<EventListItem> getEventFeed();
    EventItem getEventByID(String ID);
    void deleteEventByID(String ID);
    void createNewEvent(EventItemInput eventItemPostBody);
    void addParticipant(String ID, Participant participant);
}
