package uz.tripai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.tripai.dto.CategoryDto;
import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.request.CategoryRequest;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.entity.Category;
import uz.tripai.entity.Place;
import uz.tripai.service.CategoryService;

@Mapper(componentModel = "spring", uses = {CategoryService.class})
public abstract class PlaceMapper extends BaseMapper<Place, PlaceDto> {
    @Mapping(source = "categoryId", target = "category")
    public abstract Place toEntity(PlaceRequest dto);
}
