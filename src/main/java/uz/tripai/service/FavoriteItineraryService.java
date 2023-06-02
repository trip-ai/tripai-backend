package uz.tripai.service;

import uz.tripai.dto.FavoriteItineraryDto;
import uz.tripai.dto.request.FavoriteItineraryRequest;
import uz.tripai.entity.FavoriteItinerary;

public interface FavoriteItineraryService extends BaseService<FavoriteItinerary, FavoriteItineraryDto> {
    FavoriteItineraryDto create(FavoriteItineraryRequest obj);
    FavoriteItineraryDto updateById(long id, FavoriteItineraryRequest obj);
    FavoriteItinerary findById(long id);
}
