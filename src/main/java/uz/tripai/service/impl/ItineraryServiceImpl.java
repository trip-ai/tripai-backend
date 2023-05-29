package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.CategoryDto;
import uz.tripai.dto.ItineraryDto;
import uz.tripai.dto.request.CategoryRequest;
import uz.tripai.dto.request.ItineraryRequest;
import uz.tripai.entity.Category;
import uz.tripai.entity.Itinerary;
import uz.tripai.mapper.CategoryMapper;
import uz.tripai.mapper.ItineraryMapper;
import uz.tripai.repository.CategoryRepository;
import uz.tripai.repository.ItineraryRepository;
import uz.tripai.service.CategoryService;
import uz.tripai.service.ItineraryService;

@Service
public class ItineraryServiceImpl extends BaseServiceImpl<Itinerary, ItineraryDto, ItineraryRepository, ItineraryMapper> implements ItineraryService {
    private final ItineraryRepository repository;
    private final ItineraryMapper mapper;
    @Autowired
    public ItineraryServiceImpl(ItineraryRepository repository, ItineraryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ItineraryDto create(ItineraryRequest obj) {
        Itinerary entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ItineraryDto updateById(long id, ItineraryRequest obj) {
        Itinerary existingEntity = findById(id);
        Itinerary entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
