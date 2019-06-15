package hipevents.event.service;

import hipevents.event.domain.EventItem;
import hipevents.event.domain.EventListItem;
import hipevents.event.exception.EventNotFoundException;
import hipevents.event.repository.EventRepository;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService = new EventServiceImpl();

    private EventItem mockEventItem;
    private List<EventItem> eventList;

    @Before
    public void setUp() {
        mockEventItem = getMockEventItem();
        eventList = Collections.singletonList(getMockEventItem());
    }


    @Test
    public void testGetEventByID_Found() {
        Mockito.when(eventRepository.findById("123")).thenReturn(Optional.of(mockEventItem));
        EventItem event = eventService.getEventByID("123");
        assertNotNull(event);
    }

    @Test(expected = EventNotFoundException.class)
    public void testGetEventByID_NotFound() {
        Mockito.when(eventRepository.findById("123")).thenReturn(Optional.ofNullable(null));
        eventService.getEventByID("123");
    }

    @Test
    public void testGetEventFeed() {
        Mockito.when(eventRepository.findAll()).thenReturn(eventList);
        List<EventListItem> eventListItems = eventService.getEventFeed();
        assertEquals(1, eventListItems.size());
        assertEquals("123", eventListItems.get(0).id);
        assertEquals("Test event", eventListItems.get(0).name);
        assertEquals("Test Description", eventListItems.get(0).description);
    }

    @Test
    public void testPrivateHideStringMethod() {

    }

    private EventItem getMockEventItem() {
        EventItem eventItem = new EventItem();
        eventItem.setId("123");
        eventItem.setName("Test event");
        eventItem.setDescription("Test Description");
        return eventItem;
    }
}
