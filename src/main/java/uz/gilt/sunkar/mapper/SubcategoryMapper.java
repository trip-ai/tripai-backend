package uz.gilt.sunkar.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.SubcategoryDto;
import uz.gilt.sunkar.dto.request.CategoryRequest;
import uz.gilt.sunkar.dto.request.SubcategoryRequest;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.entity.Subcategory;
import uz.gilt.sunkar.service.CategoryService;

@Mapper(componentModel = "spring", uses = {CategoryService.class})
public abstract class SubcategoryMapper extends BaseMapper<Subcategory, SubcategoryDto> {
    @Mapping(source = "categoryId", target = "category")
    public abstract Subcategory toEntity(SubcategoryRequest dto);

}
