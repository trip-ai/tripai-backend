package uz.tripai.mapper;

import org.mapstruct.Mapper;
import uz.tripai.dto.EventDto;
import uz.tripai.dto.request.EventRequest;
import uz.tripai.entity.Event;

@Mapper(componentModel = "spring")
public abstract class EventMapper extends BaseMapper<Event, EventDto> {
    public abstract Event toEntity(EventRequest dto);
}
