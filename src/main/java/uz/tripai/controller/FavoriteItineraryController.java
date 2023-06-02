package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.FavoriteItineraryDto;
import uz.tripai.dto.request.FavoriteItineraryRequest;
import uz.tripai.entity.FavoriteItinerary;
import uz.tripai.service.BaseService;
import uz.tripai.service.FavoriteItineraryService;

@RestController
@RequestMapping("api/favorite-itinerary")
@RequiredArgsConstructor
public class FavoriteItineraryController extends BaseController<FavoriteItinerary, FavoriteItineraryDto>{
    private final FavoriteItineraryService service;
    @Override
    protected BaseService<FavoriteItinerary, FavoriteItineraryDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<FavoriteItineraryDto> create(@RequestBody FavoriteItineraryRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<FavoriteItineraryDto> update(@PathVariable("id") long id, @RequestBody FavoriteItineraryRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
