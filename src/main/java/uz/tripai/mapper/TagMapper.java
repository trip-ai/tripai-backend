package uz.tripai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.TagDto;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.dto.request.TagRequest;
import uz.tripai.entity.Place;
import uz.tripai.entity.Tag;
import uz.tripai.service.CategoryService;

@Mapper(componentModel = "spring")
public abstract class TagMapper extends BaseMapper<Tag, TagDto> {
    public abstract Tag toEntity(TagRequest dto);
}
