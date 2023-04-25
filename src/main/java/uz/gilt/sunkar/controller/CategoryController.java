package uz.gilt.sunkar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.gilt.sunkar.entity.Category;
import uz.gilt.sunkar.repository.CategoryRepository;
import uz.gilt.sunkar.service.BaseService;
import uz.gilt.sunkar.service.CategoryService;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController extends BaseController<Category>{
    public final CategoryService service;
    @Override
    protected BaseService<Category> getService() {
        return service;
    }

}
