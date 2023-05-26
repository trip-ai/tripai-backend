package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.CategoryDto;
import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.request.CategoryRequest;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.entity.Category;
import uz.tripai.entity.Place;
import uz.tripai.mapper.CategoryMapper;
import uz.tripai.mapper.PlaceMapper;
import uz.tripai.repository.CategoryRepository;
import uz.tripai.repository.PlaceRepository;
import uz.tripai.service.CategoryService;
import uz.tripai.service.PlaceService;

@Service
public class PlaceServiceImpl extends BaseServiceImpl<Place, PlaceDto, PlaceRepository, PlaceMapper> implements PlaceService {
    private final PlaceRepository repository;
    private final PlaceMapper mapper;
    @Autowired
    public PlaceServiceImpl(PlaceRepository repository, PlaceMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PlaceDto create(PlaceRequest obj) {
        Place entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public PlaceDto updateById(long id, PlaceRequest obj) {
        Place existingEntity = findById(id);
        Place entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
