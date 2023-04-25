package uz.gilt.sunkar.controller;

import org.springframework.web.bind.annotation.*;
import uz.gilt.sunkar.service.BaseService;

import java.util.List;

@RestController
public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    @GetMapping
    public List<T> getAll(){
        return getService().getAll();
    }

    @GetMapping("{id}")
    public T getAll(@PathVariable("id") long id){
        return getService().getById(id);
    }

    @PostMapping
    public T create(@RequestBody T obj){
        return getService().create(obj);
    }

    @PutMapping("{id}")
    public T update(@PathVariable("id") long id, @RequestBody T obj){
        return getService().updateById(id, obj);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        getService().deleteById(id);
    }
}
