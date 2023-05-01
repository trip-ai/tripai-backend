package uz.gilt.sunkar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.SubcategoryDto;
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
    @Autowired
    public SubcategoryServiceImpl(SubcategoryRepository repository, SubcategoryMapper mapper) {
        super(repository, mapper);
    }
}
