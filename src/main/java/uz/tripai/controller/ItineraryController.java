package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.ItineraryDto;
import uz.tripai.dto.request.ItineraryRequest;
import uz.tripai.entity.Itinerary;
import uz.tripai.service.BaseService;
import uz.tripai.service.ItineraryService;

@RestController
@RequestMapping("api/itinerary")
@RequiredArgsConstructor
public class ItineraryController extends BaseController<Itinerary, ItineraryDto>{
    private final ItineraryService service;
    @Override
    protected BaseService<Itinerary, ItineraryDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<ItineraryDto> create(@RequestBody ItineraryRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<ItineraryDto> update(@PathVariable("id") long id, @RequestBody ItineraryRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
