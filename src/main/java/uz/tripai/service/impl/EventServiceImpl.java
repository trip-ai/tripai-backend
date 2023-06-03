package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.EventDto;
import uz.tripai.dto.request.EventRequest;
import uz.tripai.entity.Event;
import uz.tripai.mapper.EventMapper;
import uz.tripai.repository.EventRepository;
import uz.tripai.service.EventService;

@Service
public class EventServiceImpl extends BaseServiceImpl<Event, EventDto, EventRepository, EventMapper> implements EventService {
    private final EventRepository repository;
    private final EventMapper mapper;
    @Autowired
    public EventServiceImpl(EventRepository repository, EventMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EventDto create(EventRequest obj) {
        Event entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public EventDto updateById(long id, EventRequest obj) {
        Event existingEntity = findById(id);
        Event entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
