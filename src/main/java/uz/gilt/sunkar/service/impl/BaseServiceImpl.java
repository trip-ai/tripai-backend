package uz.gilt.sunkar.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uz.gilt.sunkar.service.BaseService;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T, R extends JpaRepository<T, Long>> implements BaseService<T> {
    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T updateById(long id, T entity) {
        T existingEntity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        BeanUtils.copyProperties(entity, existingEntity);
        return repository.save(existingEntity);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
