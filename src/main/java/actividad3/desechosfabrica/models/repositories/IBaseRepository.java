package actividad3.desechosfabrica.models.repositories;

import java.util.List;
import java.util.Optional;

import actividad3.desechosfabrica.models.entities.BaseEntity;

public interface IBaseRepository<T extends BaseEntity, ID> {
  public T save(T entity);

  public Optional<T> findById(ID id);

  public List<T> findAll();

  public void delete(T entity);
}
