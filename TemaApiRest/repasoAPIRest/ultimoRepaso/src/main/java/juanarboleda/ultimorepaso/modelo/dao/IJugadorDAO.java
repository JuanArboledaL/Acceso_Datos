package juanarboleda.ultimorepaso.modelo.dao;

import juanarboleda.ultimorepaso.modelo.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJugadorDAO extends CrudRepository<EntidadJugadores, Integer> {
}
