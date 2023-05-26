package uz.tripai.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import uz.tripai.entity.Place;

import java.sql.Timestamp;
import java.util.List;

public record PlaceDto(
        long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp updatedAt,
        long categoryId,
        String name,
        String address,
        String description,
        List<String> images,
        Place.Location location,
        List<Place.Workday> workdays,
        boolean status,
        Double rating
) {
}
