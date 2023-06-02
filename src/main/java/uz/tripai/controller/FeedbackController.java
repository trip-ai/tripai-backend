package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.FeedbackDto;
import uz.tripai.dto.request.FeedbackRequest;
import uz.tripai.entity.Feedback;
import uz.tripai.service.BaseService;
import uz.tripai.service.FeedbackService;

@RestController
@RequestMapping("api/feedback")
@RequiredArgsConstructor
public class FeedbackController extends BaseController<Feedback, FeedbackDto>{
    private final FeedbackService service;
    @Override
    protected BaseService<Feedback, FeedbackDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<FeedbackDto> create(@RequestBody FeedbackRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<FeedbackDto> update(@PathVariable("id") long id, @RequestBody FeedbackRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
