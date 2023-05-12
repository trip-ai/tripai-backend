package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.CategoryDto;
import uz.tripai.dto.request.CategoryRequest;
import uz.tripai.entity.Category;
import uz.tripai.service.BaseService;
import uz.tripai.service.CategoryService;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController extends BaseController<Category, CategoryDto>{
    private final CategoryService service;
    @Override
    protected BaseService<Category, CategoryDto> getService() {
        return service;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryRequest obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable("id") long id, @RequestBody CategoryRequest obj){
        return ResponseEntity.ok(service.updateById(id, obj));
    }
}
