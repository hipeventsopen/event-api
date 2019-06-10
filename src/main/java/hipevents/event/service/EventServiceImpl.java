package hipevents.event.service;

import hipevents.event.domain.*;
import hipevents.event.exception.EventNotFoundException;
import hipevents.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<EventListItem> getEventFeed() {
        return eventRepository.findAll().stream()
                .map(EventListItem::new)
                .collect(Collectors.toList());
    }

    @Override
    public EventItem getEventByID(String ID) {
        return eventRepository.findById(ID)
                .orElseThrow(() -> new EventNotFoundException(ID));
    }

    @Override
    public void deleteEventByID(String ID) {
        eventRepository.deleteById(ID);
    }

    @Override
    public void createNewEvent(EventItemInput eventItemInput) {
        eventRepository.save(new EventItem(eventItemInput));
    }

    @Override
    public void addParticipant(String ID, Participant participant) {

    }

}
