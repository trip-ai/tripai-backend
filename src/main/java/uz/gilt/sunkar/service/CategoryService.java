package uz.gilt.sunkar.service;

import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.request.CategoryRequest;
import uz.gilt.sunkar.entity.Category;

public interface CategoryService extends BaseService<Category, CategoryDto> {
    CategoryDto create(CategoryRequest obj);
    CategoryDto updateById(long id, CategoryRequest obj);
    Category findById(long id);
}
