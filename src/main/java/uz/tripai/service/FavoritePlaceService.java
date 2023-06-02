package uz.tripai.service;

import uz.tripai.dto.FavoritePlaceDto;
import uz.tripai.dto.request.FavoritePlaceRequest;
import uz.tripai.entity.FavoritePlace;

public interface FavoritePlaceService extends BaseService<FavoritePlace, FavoritePlaceDto> {
    FavoritePlaceDto create(FavoritePlaceRequest obj);
    FavoritePlaceDto updateById(long id, FavoritePlaceRequest obj);
    FavoritePlace findById(long id);
}
