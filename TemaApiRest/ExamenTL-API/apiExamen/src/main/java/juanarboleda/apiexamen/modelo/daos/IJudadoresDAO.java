package juanarboleda.apiexamen.modelo.daos;

import juanarboleda.apiexamen.modelo.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;

public interface IJudadoresDAO extends CrudRepository<EntidadJugadores, Integer> {


}
