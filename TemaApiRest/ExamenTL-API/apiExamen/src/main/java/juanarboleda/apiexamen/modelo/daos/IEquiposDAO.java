package juanarboleda.apiexamen.modelo.daos;

import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquiposDAO extends CrudRepository<EntidadEquipos, Integer> {


}
