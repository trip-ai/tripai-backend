package uz.gilt.sunkar.mapper;

import org.mapstruct.Mapper;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.request.CategoryRequest;
import uz.gilt.sunkar.entity.Category;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper extends BaseMapper<Category, CategoryDto> {
    public abstract Category toEntity(CategoryRequest dto);
}
