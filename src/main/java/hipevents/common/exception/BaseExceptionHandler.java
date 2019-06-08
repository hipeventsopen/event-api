package hipevents.common.exception;

import hipevents.event.exception.EventNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class BaseExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity handleEventNotFoundException(EventNotFoundException e) {
        logger.warn("Event not found. id={}, Exception={}", e.id, e);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity handleUndefinedException(Exception e) {
        logger.error("Error={1}", e);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
