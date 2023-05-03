package uz.gilt.sunkar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.SubcategoryDto;
import uz.gilt.sunkar.dto.request.CategoryRequest;
import uz.gilt.sunkar.dto.request.SubcategoryRequest;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.entity.Subcategory;
import uz.gilt.sunkar.service.BaseService;
import uz.gilt.sunkar.service.CategoryService;
import uz.gilt.sunkar.service.SubcategoryService;

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
