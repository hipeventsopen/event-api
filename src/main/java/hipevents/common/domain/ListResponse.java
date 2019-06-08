package hipevents.common.domain;

import java.util.List;

public class ListResponse<T> {
    public final List<T> items;

    public ListResponse(List<T> items) {
        this.items = items;
    }
}