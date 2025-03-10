package juanarboleda.thymeultimo.modelo.dao;

import juanarboleda.thymeultimo.modelo.entidades.Partidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidosDAO extends CrudRepository<Partidos, Integer> {
}
