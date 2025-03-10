package juanarboleda.thymeultimo.modelo.dao;

import juanarboleda.thymeultimo.modelo.entidades.Jugadores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJugadorDAO extends CrudRepository<Jugadores, Integer> {
}
