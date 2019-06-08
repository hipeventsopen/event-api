package hipevents.event;

import hipevents.common.domain.ListResponse;
import hipevents.event.domain.EventItem;
import hipevents.event.domain.EventListItem;
import hipevents.event.domain.EventItemInput;
import hipevents.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ListResponse<EventListItem> getEventFeed() {
        return new ListResponse<>(eventService.getEventFeed());
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public EventItem getEvent(@PathVariable("id") String id) {
        return eventService.getEventByID(id);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEvent(@PathVariable("id") String id) {
        eventService.deleteEventByID(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public ResponseEntity createNewEvent(@RequestBody EventItemInput eventItemInput) {
        eventService.createNewEvent(eventItemInput);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}