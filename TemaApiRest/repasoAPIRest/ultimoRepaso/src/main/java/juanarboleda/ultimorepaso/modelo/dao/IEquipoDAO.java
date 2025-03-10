package juanarboleda.ultimorepaso.modelo.dao;

import juanarboleda.ultimorepaso.modelo.entidades.EntidadEquipos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoDAO extends CrudRepository<EntidadEquipos, Integer> {

    public EntidadEquipos findByNombre(String nombre);
}
