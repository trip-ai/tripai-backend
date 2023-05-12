package uz.tripai.service;

import uz.tripai.dto.CategoryDto;
import uz.tripai.dto.request.CategoryRequest;
import uz.tripai.entity.Category;

public interface CategoryService extends BaseService<Category, CategoryDto> {
    CategoryDto create(CategoryRequest obj);
    CategoryDto updateById(long id, CategoryRequest obj);
    Category findById(long id);
}
