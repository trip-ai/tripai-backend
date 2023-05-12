package uz.tripai.service;

import uz.tripai.dto.SubcategoryDto;
import uz.tripai.dto.request.SubcategoryRequest;
import uz.tripai.entity.Subcategory;

public interface SubcategoryService extends BaseService<Subcategory, SubcategoryDto> {
    SubcategoryDto create(SubcategoryRequest obj);
    SubcategoryDto updateById(long id, SubcategoryRequest obj);
}
