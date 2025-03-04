package juanarboleda.apiexamen.modelo.daos;

import juanarboleda.apiexamen.modelo.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IJugadores extends CrudRepository<EntidadJugadores, Integer> {

}
