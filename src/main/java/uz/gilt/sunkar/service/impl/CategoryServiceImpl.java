package uz.gilt.sunkar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.gilt.sunkar.dto.CategoryReqDto;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.mapper.CategoryMapper;
import uz.gilt.sunkar.repository.CategoryRepository;
import uz.gilt.sunkar.service.CategoryService;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryReqDto, CategoryRepository, CategoryMapper> implements CategoryService  {
    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }
}
