package uz.tripai.mapper;

import java.util.List;

public abstract class BaseMapper<T, D> {

    public abstract D toDto(T entity);

    public abstract List<D> toDtoList(List<T> entityList);

    public abstract T toEntity(D dto);

    public abstract List<T> toEntityList(List<D> dtoList);
}
