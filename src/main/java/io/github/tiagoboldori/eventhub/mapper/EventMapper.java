package io.github.tiagoboldori.eventhub.mapper;

import io.github.tiagoboldori.eventhub.dto.response.EventDashboardResponse;
import io.github.tiagoboldori.eventhub.entity.Event;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMapper {

    public EventDashboardResponse toEventDashboardResponse(Event event) {

        EventDashboardResponse response = new EventDashboardResponse();

        response.setId(event.getId());
        response.setName(event.getName());
        response.setDescription(event.getDescription());
        response.setStartDate(event.getStartDate());

        return response;
    }

    public List<EventDashboardResponse> toEventDashboardResponseList(List<Event> events){
        return events.stream()
                .map(this::toEventDashboardResponse)
                .toList();
    }




}