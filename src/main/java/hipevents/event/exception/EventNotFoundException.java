package hipevents.event.exception;

public class EventNotFoundException extends RuntimeException {

    public final String id;

    public EventNotFoundException(String id) {
        this.id = id;
    }
}
