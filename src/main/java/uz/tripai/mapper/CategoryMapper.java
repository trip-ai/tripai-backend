package uz.tripai.mapper;

import org.mapstruct.Mapper;
import uz.tripai.dto.CategoryDto;
import uz.tripai.dto.request.CategoryRequest;
import uz.tripai.entity.Category;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper extends BaseMapper<Category, CategoryDto> {
    public abstract Category toEntity(CategoryRequest dto);
}
