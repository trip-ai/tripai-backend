package uz.tripai.service;

import uz.tripai.dto.FavoritePlaceDto;
import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.request.FavoritePlaceRequest;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.entity.FavoritePlace;
import uz.tripai.entity.Feedback;

public interface FavoritePlaceService extends BaseService<FavoritePlace, FavoritePlaceDto> {
    FavoritePlaceDto create(FavoritePlaceRequest obj);
    FavoritePlaceDto updateById(long id, FavoritePlaceRequest obj);
    FavoritePlace findById(long id);
}
