package uz.tripai.service;

import uz.tripai.dto.ItineraryDto;
import uz.tripai.dto.request.ItineraryRequest;
import uz.tripai.entity.Itinerary;

public interface ItineraryService extends BaseService<Itinerary, ItineraryDto> {
    ItineraryDto create(ItineraryRequest obj);
    ItineraryDto updateById(long id, ItineraryRequest obj);
    Itinerary findById(long id);
}
