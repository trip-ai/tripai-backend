package uz.tripai.dto.request;

import uz.tripai.entity.Place;

import java.util.List;

public record PlaceRequest(
        long categoryId,
        String name,
        String address,
        String description,
        List<String> images,
        Place.Location location,
        List<Place.Workday> workdays,
        boolean status
) {
}
