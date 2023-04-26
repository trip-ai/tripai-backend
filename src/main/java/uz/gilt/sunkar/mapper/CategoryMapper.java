package uz.gilt.sunkar.mapper;

import org.mapstruct.Mapper;
import uz.gilt.sunkar.dto.CategoryReqDto;
import uz.gilt.sunkar.entity.Category;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper extends BaseMapper<Category, CategoryReqDto> {

}
