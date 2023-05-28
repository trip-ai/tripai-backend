package uz.tripai.service;

import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.TagDto;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.dto.request.TagRequest;
import uz.tripai.entity.Place;
import uz.tripai.entity.Tag;

public interface TagService extends BaseService<Tag, TagDto> {
    TagDto create(TagRequest obj);
    TagDto updateById(long id, TagRequest obj);
    Tag findById(long id);
}
