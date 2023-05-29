package uz.tripai.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import uz.tripai.entity.Place;

import java.sql.Timestamp;
import java.util.List;

public record ItineraryDto(
        long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp updatedAt,
        long userId,
        boolean isPublic,
        boolean status
) {
}
