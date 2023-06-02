package uz.tripai.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public record FavoritePlaceRequest(
        long userId,
        long placeId,
        boolean status
) {
}
