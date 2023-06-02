package uz.tripai.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.List;

public record FavoritePlaceDto(
        long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp updatedAt,
        long userId,
        long placeId,
        boolean status
) {
}
