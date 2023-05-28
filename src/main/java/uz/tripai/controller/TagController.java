package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.PlaceDto;
import uz.tripai.dto.TagDto;
import uz.tripai.dto.request.PlaceRequest;
import uz.tripai.dto.request.TagRequest;
import uz.tripai.entity.Place;
import uz.tripai.entity.Tag;
import uz.tripai.service.BaseService;
import uz.tripai.service.PlaceService;
import uz.tripai.service.TagService;

@RestController
@RequestMapping("api/tag")
@RequiredArgsConstructor
public class TagController extends BaseController<Tag, TagDto>{
    private final TagService service;
    @Override
    protected BaseService<Tag, TagDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<TagDto> create(@RequestBody TagRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<TagDto> update(@PathVariable("id") long id, @RequestBody TagRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
