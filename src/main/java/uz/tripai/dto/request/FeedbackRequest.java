package uz.tripai.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.List;

public record FeedbackRequest(
        long userId,
        long placeId,
        double rating,
        String comment,
        List<String> images
) {
}
