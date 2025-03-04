package juanarboleda.apiexamen.modelo.daos;

import juanarboleda.apiexamen.modelo.entidades.EntidadPartidos;
import org.springframework.data.repository.CrudRepository;

public interface IPartidosDAO extends CrudRepository<EntidadPartidos, Integer> {

}
