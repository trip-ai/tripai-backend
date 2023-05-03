package uz.gilt.sunkar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.gilt.sunkar.dto.request.CategoryRequest;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.service.BaseService;
import uz.gilt.sunkar.service.CategoryService;

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
