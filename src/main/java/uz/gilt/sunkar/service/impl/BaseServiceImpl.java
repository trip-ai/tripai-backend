package uz.gilt.sunkar.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.gilt.sunkar.entity.BaseEntity;
import uz.gilt.sunkar.mapper.BaseMapper;
import uz.gilt.sunkar.service.BaseService;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T extends BaseEntity, D extends Record, R extends JpaRepository<T, Long>, M extends BaseMapper<T, D>> implements BaseService<T, D> {
    private final R repository;
    private final M mapper;

    public BaseServiceImpl(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<D> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public D getById(long id) {
        return mapper.toDto(findById(id));
    }
    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public T findById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Resource not found (id: %d)", id)));
    }
}
