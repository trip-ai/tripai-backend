package uz.gilt.sunkar.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<T> {
    List<T> getAll();
    T getById(long id);
    T create(T obj);
    T updateById(long id, T obj);
    void deleteById(long id);
}
