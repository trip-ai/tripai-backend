package uz.tripai.dto.request;

public record ItineraryRequest(
        long userId,
        boolean isPublic,
        boolean status
) {
}
