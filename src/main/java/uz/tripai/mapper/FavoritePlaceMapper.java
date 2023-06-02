package uz.tripai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.tripai.dto.FavoritePlaceDto;
import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.request.FavoritePlaceRequest;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.entity.FavoritePlace;
import uz.tripai.entity.Feedback;
import uz.tripai.service.PlaceService;
import uz.tripai.service.UserService;

@Mapper(componentModel = "spring", uses = {UserService.class, PlaceService.class})
public abstract class FavoritePlaceMapper extends BaseMapper<FavoritePlace, FavoritePlaceDto> {
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "placeId", target = "place")
    public abstract FavoritePlace toEntity(FavoritePlaceRequest dto);
}
