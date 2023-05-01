package uz.gilt.sunkar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.gilt.sunkar.dto.CategoryDto;
import uz.gilt.sunkar.dto.SubcategoryDto;
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
}
