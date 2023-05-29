package uz.tripai.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public record ItineraryRequest(
        long userId,
        boolean isPublic,
        boolean status
) {
}
