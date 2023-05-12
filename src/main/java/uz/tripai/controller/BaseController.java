package uz.tripai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.service.BaseService;

import java.util.List;

@RestController
public abstract class BaseController<T, D> {

    protected abstract BaseService<T, D> getService();

    @GetMapping
    public ResponseEntity<List<D>> getAll(){
        return ResponseEntity.ok(getService().getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<D> getAll(@PathVariable("id") long id){
        return ResponseEntity.ok(getService().getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        getService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
