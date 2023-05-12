package uz.tripai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.tripai.dto.SubcategoryDto;
import uz.tripai.dto.request.SubcategoryRequest;
import uz.tripai.entity.Subcategory;
import uz.tripai.service.CategoryService;

@Mapper(componentModel = "spring", uses = {CategoryService.class})
public abstract class SubcategoryMapper extends BaseMapper<Subcategory, SubcategoryDto> {
    @Mapping(source = "categoryId", target = "category")
    public abstract Subcategory toEntity(SubcategoryRequest dto);

}
