package juanarboleda.ultimorepaso.modelo.dao;

import juanarboleda.ultimorepaso.modelo.entidades.EntidadPartidos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPartidoDAO extends CrudRepository<EntidadPartidos, Integer> {

    @Query("SELECT p FROM EntidadPartidos p WHERE p.golesLocal > p.golesVisitante")
    List<EntidadPartidos> mostrarPartidosGanadosByEquipoLocal();
}
