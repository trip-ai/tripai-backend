package uz.tripai.service;

import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.entity.Place;

public interface PlaceService extends BaseService<Place, PlaceDto> {
    PlaceDto create(PlaceRequest obj);
    PlaceDto updateById(long id, PlaceRequest obj);
    Place findById(long id);
}
