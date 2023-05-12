package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.SubcategoryDto;
import uz.tripai.dto.request.SubcategoryRequest;
import uz.tripai.entity.Subcategory;
import uz.tripai.service.BaseService;
import uz.tripai.service.SubcategoryService;

@RestController
@RequestMapping("api/subcategory")
@RequiredArgsConstructor
public class SubcategoryController extends BaseController<Subcategory, SubcategoryDto>{
    private final SubcategoryService service;
    @Override
    protected BaseService<Subcategory, SubcategoryDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<SubcategoryDto> create(@RequestBody SubcategoryRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<SubcategoryDto> update(@PathVariable("id") long id, @RequestBody SubcategoryRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
