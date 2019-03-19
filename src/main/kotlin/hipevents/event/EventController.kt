package hipevents.event

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import hipevents.common.API_ROOT
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping(API_ROOT)
class EventController {

    @GetMapping("/events")
    fun getEvents() =
        EventsResponse(
            listOf(
                Event(
                    "Test Event",
                    "Description of the test hipevents.event. Everything is hard coded"
                )))
}