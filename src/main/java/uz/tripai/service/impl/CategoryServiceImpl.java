package uz.tripai.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.tripai.dto.CategoryDto;
import uz.tripai.dto.request.CategoryRequest;
import uz.tripai.entity.Category;
import uz.tripai.mapper.CategoryMapper;
import uz.tripai.repository.CategoryRepository;
import uz.tripai.service.CategoryService;

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
        Category existingEntity = findById(id);
        Category entity = mapper.toEntity(obj);
        BeanUtils.copyProperties(entity, existingEntity, "id", "createdAt", "updatedAt");
        return mapper.toDto(repository.save(existingEntity));
    }
}
