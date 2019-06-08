package hipevents.event.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Participant {

    @JsonIgnore
    private String userId;
    private String username;
    private String attendance;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
