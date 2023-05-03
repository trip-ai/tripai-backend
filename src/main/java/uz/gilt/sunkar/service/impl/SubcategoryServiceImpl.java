package uz.gilt.sunkar.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.SubcategoryDto;
import uz.gilt.sunkar.dto.request.SubcategoryRequest;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.entity.Subcategory;
import uz.gilt.sunkar.mapper.CategoryMapper;
import uz.gilt.sunkar.mapper.SubcategoryMapper;
import uz.gilt.sunkar.repository.CategoryRepository;
import uz.gilt.sunkar.repository.SubcategoryRepository;
import uz.gilt.sunkar.service.CategoryService;
import uz.gilt.sunkar.service.SubcategoryService;

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
        Subcategory existingEntity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        Subcategory entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
