package uz.gilt.sunkar.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<T, D> {
    List<D> getAll();
    D getById(long id);
    void deleteById(long id);
    T findById(long id);
}
