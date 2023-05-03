package uz.gilt.sunkar.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.request.CategoryRequest;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.mapper.CategoryMapper;
import uz.gilt.sunkar.repository.CategoryRepository;
import uz.gilt.sunkar.service.CategoryService;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryDto, CategoryRepository, CategoryMapper> implements CategoryService  {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto create(CategoryRequest obj) {
        Category entity = mapper.toEntity(obj);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CategoryDto updateById(long id, CategoryRequest obj) {
        Category existingEntity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        Category entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }

    @Override
    public Category findById(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
