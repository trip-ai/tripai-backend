package uz.tripai.mapper;

import org.mapstruct.Mapper;
import uz.tripai.dto.TagDto;
import uz.tripai.dto.request.TagRequest;
import uz.tripai.entity.Tag;

@Mapper(componentModel = "spring")
public abstract class TagMapper extends BaseMapper<Tag, TagDto> {
    public abstract Tag toEntity(TagRequest dto);
}
