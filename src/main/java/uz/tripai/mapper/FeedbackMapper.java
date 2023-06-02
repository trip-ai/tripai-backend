package uz.tripai.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.entity.Feedback;
import uz.tripai.service.PlaceService;
import uz.tripai.service.UserService;

@Mapper(componentModel = "spring", uses = {UserService.class, PlaceService.class})
public abstract class FeedbackMapper extends BaseMapper<Feedback, FeedbackDto> {
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "placeId", target = "place")
    public abstract Feedback toEntity(FeedbackRequest dto);
}
