package juanarboleda.thymeultimo.modelo.dao;

import juanarboleda.thymeultimo.modelo.entidades.Equipos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoDAO extends CrudRepository<Equipos, Integer> {
}
