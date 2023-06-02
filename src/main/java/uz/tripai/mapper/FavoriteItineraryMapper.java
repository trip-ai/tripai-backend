package uz.tripai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.tripai.dto.FavoriteItineraryDto;
import uz.tripai.dto.request.FavoriteItineraryRequest;
import uz.tripai.entity.FavoriteItinerary;
import uz.tripai.service.ItineraryService;
import uz.tripai.service.UserService;

@Mapper(componentModel = "spring", uses = {UserService.class, ItineraryService.class})
public abstract class FavoriteItineraryMapper extends BaseMapper<FavoriteItinerary, FavoriteItineraryDto> {
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "itineraryId", target = "itinerary")
    public abstract FavoriteItinerary toEntity(FavoriteItineraryRequest dto);
}
