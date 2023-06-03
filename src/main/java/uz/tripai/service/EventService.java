package uz.tripai.service;

import uz.tripai.dto.EventDto;
import uz.tripai.dto.request.EventRequest;
import uz.tripai.entity.Event;

public interface EventService extends BaseService<Event, EventDto> {
    EventDto create(EventRequest obj);
    EventDto updateById(long id, EventRequest obj);
    Event findById(long id);
}
