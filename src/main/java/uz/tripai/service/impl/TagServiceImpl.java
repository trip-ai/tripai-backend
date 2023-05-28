package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.TagDto;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.dto.request.TagRequest;
import uz.tripai.entity.Place;
import uz.tripai.entity.Tag;
import uz.tripai.mapper.PlaceMapper;
import uz.tripai.mapper.TagMapper;
import uz.tripai.repository.PlaceRepository;
import uz.tripai.repository.TagRepository;
import uz.tripai.service.PlaceService;
import uz.tripai.service.TagService;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, TagDto, TagRepository, TagMapper> implements TagService {
    private final TagRepository repository;
    private final TagMapper mapper;
    @Autowired
    public TagServiceImpl(TagRepository repository, TagMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TagDto create(TagRequest obj) {
        Tag entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public TagDto updateById(long id, TagRequest obj) {
        Tag existingEntity = findById(id);
        Tag entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
