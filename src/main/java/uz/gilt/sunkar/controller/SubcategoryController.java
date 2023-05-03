package uz.gilt.sunkar.controller;

import lombok.RequiredArgsConstructor;
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
    public SubcategoryDto create(@RequestBody SubcategoryRequest obj){
        return service.create(obj);
    }

    @PutMapping("{id}")
    public SubcategoryDto update(@PathVariable("id") long id, @RequestBody SubcategoryRequest obj){
        return service.updateById(id, obj);
    }
}
