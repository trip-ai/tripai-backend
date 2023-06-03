package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.EventDto;
import uz.tripai.dto.request.EventRequest;
import uz.tripai.entity.Event;
import uz.tripai.service.BaseService;
import uz.tripai.service.EventService;

@RestController
@RequestMapping("api/event")
@RequiredArgsConstructor
public class EventController extends BaseController<Event, EventDto>{
    private final EventService service;
    @Override
    protected BaseService<Event, EventDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<EventDto> create(@RequestBody EventRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<EventDto> update(@PathVariable("id") long id, @RequestBody EventRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
