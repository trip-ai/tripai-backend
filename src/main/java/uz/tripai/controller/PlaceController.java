package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.entity.Place;
import uz.tripai.service.BaseService;
import uz.tripai.service.PlaceService;

@RestController
@RequestMapping("api/place")
@RequiredArgsConstructor
public class PlaceController extends BaseController<Place, PlaceDto>{
    private final PlaceService service;
    @Override
    protected BaseService<Place, PlaceDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<PlaceDto> create(@RequestBody PlaceRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<PlaceDto> update(@PathVariable("id") long id, @RequestBody PlaceRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
