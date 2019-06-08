package hipevents.event.repository;

import hipevents.event.domain.EventItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EventRepository extends MongoRepository<EventItem, String> {
    Optional<EventItem> findById(String id);
}
