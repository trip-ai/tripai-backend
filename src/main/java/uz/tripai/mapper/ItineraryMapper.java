package uz.tripai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.tripai.dto.ItineraryDto;
import uz.tripai.dto.request.ItineraryRequest;
import uz.tripai.entity.Itinerary;
import uz.tripai.service.UserService;

@Mapper(componentModel = "spring", uses = {UserService.class})
public abstract class ItineraryMapper extends BaseMapper<Itinerary, ItineraryDto> {
    @Mapping(source = "userId", target = "user")
    public abstract Itinerary toEntity(ItineraryRequest dto);
}
