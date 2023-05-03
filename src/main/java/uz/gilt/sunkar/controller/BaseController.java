package uz.gilt.sunkar.controller;

import org.springframework.web.bind.annotation.*;
import uz.gilt.sunkar.service.BaseService;

import java.util.List;

@RestController
public abstract class BaseController<T, D> {

    protected abstract BaseService<T, D> getService();

    @GetMapping
    public List<D> getAll(){
        return getService().getAll();
    }

    @GetMapping("{id}")
    public D getAll(@PathVariable("id") long id){
        return getService().getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        getService().deleteById(id);
    }
}
