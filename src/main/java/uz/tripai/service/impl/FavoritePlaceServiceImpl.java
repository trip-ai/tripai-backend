package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.FavoritePlaceDto;
import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.request.FavoritePlaceRequest;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.entity.FavoritePlace;
import uz.tripai.entity.Feedback;
import uz.tripai.mapper.FavoritePlaceMapper;
import uz.tripai.mapper.FeedbackMapper;
import uz.tripai.repository.FavoritePlaceRepository;
import uz.tripai.repository.FeedbackRepository;
import uz.tripai.service.FavoritePlaceService;
import uz.tripai.service.FeedbackService;

@Service
public class FavoritePlaceServiceImpl extends BaseServiceImpl<FavoritePlace, FavoritePlaceDto, FavoritePlaceRepository, FavoritePlaceMapper> implements FavoritePlaceService {
    private final FavoritePlaceRepository repository;
    private final FavoritePlaceMapper mapper;
    @Autowired
    public FavoritePlaceServiceImpl(FavoritePlaceRepository repository, FavoritePlaceMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FavoritePlaceDto create(FavoritePlaceRequest obj) {
        FavoritePlace entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public FavoritePlaceDto updateById(long id, FavoritePlaceRequest obj) {
        FavoritePlace existingEntity = findById(id);
        FavoritePlace entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
