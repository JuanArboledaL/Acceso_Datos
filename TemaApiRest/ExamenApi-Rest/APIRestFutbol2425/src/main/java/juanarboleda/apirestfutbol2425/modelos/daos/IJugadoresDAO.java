package juanarboleda.apirestfutbol2425.modelos.daos;

import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJugadoresDAO extends CrudRepository<EntidadJugadores, Integer> {

    //public List<EntidadJugadores> buscarJugadorByNombreEquipo(String nombre);

   // public Optional<EntidadJugadores> crearJugadorValidado(@RequestBody EntidadJugadores entidadJugadores);
}
