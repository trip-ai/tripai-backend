package uz.gilt.sunkar.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<T, D> {
    List<D> getAll();
    D getById(long id);
    D create(D obj);
    D updateById(long id, D obj);
    void deleteById(long id);
}
