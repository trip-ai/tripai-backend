package uz.tripai.dto.request;

public record FavoriteItineraryRequest(
        long userId,
        long itineraryId,
        boolean status
) {
}
