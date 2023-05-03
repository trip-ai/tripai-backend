package uz.gilt.sunkar.service;

import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.SubcategoryDto;
import uz.gilt.sunkar.dto.request.SubcategoryRequest;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.entity.Subcategory;

public interface SubcategoryService extends BaseService<Subcategory, SubcategoryDto> {
    SubcategoryDto create(SubcategoryRequest obj);
    SubcategoryDto updateById(long id, SubcategoryRequest obj);
}
