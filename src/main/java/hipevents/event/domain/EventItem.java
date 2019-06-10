package hipevents.event.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "events")
public class EventItem {

    @Id
    private String id;
    private String name;
    private String description;
    private List<Owner> owners;
    private LocalDateTime begins;
    private LocalDateTime ends;
    private List<Participant> participants;
    private String location;

    public EventItem() {}

    public EventItem(EventItemInput input) {
        this.name = input.getName();
        this.description = input.getDescription();
        this.begins = input.getBegins();
        this.ends = input.getEnds();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public LocalDateTime getBegins() {
        return begins;
    }

    public void setBegins(LocalDateTime begins) {
        this.begins = begins;
    }

    public LocalDateTime getEnds() {
        return ends;
    }

    public void setEnds(LocalDateTime ends) {
        this.ends = ends;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
}
