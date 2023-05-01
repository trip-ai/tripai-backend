package uz.gilt.sunkar.mapper;

import org.mapstruct.Mapper;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.SubcategoryDto;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.entity.Subcategory;

@Mapper(componentModel = "spring")
public abstract class SubcategoryMapper extends BaseMapper<Subcategory, SubcategoryDto> {

}
