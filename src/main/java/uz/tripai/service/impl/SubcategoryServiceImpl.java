package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.SubcategoryDto;
import uz.tripai.mapper.SubcategoryMapper;
import uz.tripai.repository.SubcategoryRepository;
import uz.tripai.service.SubcategoryService;
import uz.tripai.dto.request.SubcategoryRequest;
import uz.tripai.entity.Subcategory;

@Service
public class SubcategoryServiceImpl extends BaseServiceImpl<Subcategory, SubcategoryDto, SubcategoryRepository, SubcategoryMapper> implements SubcategoryService {

    private final SubcategoryRepository repository;
    private final SubcategoryMapper mapper;
    @Autowired
    public SubcategoryServiceImpl(SubcategoryRepository repository, SubcategoryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SubcategoryDto create(SubcategoryRequest obj) {
        Subcategory entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public SubcategoryDto updateById(long id, SubcategoryRequest obj) {
        Subcategory existingEntity = findById(id);
        Subcategory entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
