package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.FavoritePlaceDto;
import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.request.FavoritePlaceRequest;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.entity.FavoritePlace;
import uz.tripai.entity.Feedback;
import uz.tripai.service.BaseService;
import uz.tripai.service.FavoritePlaceService;
import uz.tripai.service.FeedbackService;

@RestController
@RequestMapping("api/favorite-place")
@RequiredArgsConstructor
public class FavoritePlaceController extends BaseController<FavoritePlace, FavoritePlaceDto>{
    private final FavoritePlaceService service;
    @Override
    protected BaseService<FavoritePlace, FavoritePlaceDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<FavoritePlaceDto> create(@RequestBody FavoritePlaceRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<FavoritePlaceDto> update(@PathVariable("id") long id, @RequestBody FavoritePlaceRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
