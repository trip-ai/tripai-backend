package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.FavoriteItineraryDto;
import uz.tripai.dto.request.FavoriteItineraryRequest;
import uz.tripai.entity.FavoriteItinerary;
import uz.tripai.mapper.FavoriteItineraryMapper;
import uz.tripai.repository.FavoriteItineraryRepository;
import uz.tripai.service.FavoriteItineraryService;

@Service
public class FavoriteItineraryServiceImpl extends BaseServiceImpl<FavoriteItinerary, FavoriteItineraryDto, FavoriteItineraryRepository, FavoriteItineraryMapper> implements FavoriteItineraryService {
    private final FavoriteItineraryRepository repository;
    private final FavoriteItineraryMapper mapper;
    @Autowired
    public FavoriteItineraryServiceImpl(FavoriteItineraryRepository repository, FavoriteItineraryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FavoriteItineraryDto create(FavoriteItineraryRequest obj) {
        FavoriteItinerary entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public FavoriteItineraryDto updateById(long id, FavoriteItineraryRequest obj) {
        FavoriteItinerary existingEntity = findById(id);
        FavoriteItinerary entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
