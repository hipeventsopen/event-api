package hipevents.event;

import hipevents.common.Constants;
import hipevents.common.domain.ListResponse;
import hipevents.event.domain.EventItem;
import hipevents.event.domain.EventItemInput;
import hipevents.event.domain.EventListItem;
import hipevents.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API_ROOT + "/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ListResponse<EventListItem> getEventFeed() {
        return new ListResponse<>(eventService.getEventFeed());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EventItem getEvent(@PathVariable("id") String id) {
        return eventService.getEventByID(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEvent(@PathVariable("id") String id) {
        eventService.deleteEventByID(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewEvent(@RequestBody EventItemInput eventItemPostBody) {
        eventService.createNewEvent(eventItemPostBody);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}