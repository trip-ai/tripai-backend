package uz.tripai.dto.request;

import java.util.List;

public record FeedbackRequest(
        long userId,
        long placeId,
        double rating,
        String comment,
        List<String> images
) {
}
