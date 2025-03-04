package juanarboleda.apirestfutbol2425.modelos.daos;

import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadJugadores;
import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadPartidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidosDAO extends CrudRepository<EntidadPartidos, Integer> {
}
