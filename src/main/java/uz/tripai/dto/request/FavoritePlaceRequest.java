package uz.tripai.dto.request;

public record FavoritePlaceRequest(
        long userId,
        long placeId,
        boolean status
) {
}
