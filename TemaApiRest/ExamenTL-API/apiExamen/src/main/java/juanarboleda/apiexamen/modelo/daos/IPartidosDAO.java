package juanarboleda.apiexamen.modelo.daos;

import juanarboleda.apiexamen.modelo.entidades.EntidadPartidos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPartidosDAO extends CrudRepository<EntidadPartidos, Integer> {

    @Query("SELECT p FROM EntidadPartidos p WHERE p.golesLocal > p.golesVisitante")
    List<EntidadPartidos> findPartidosGanadosPorEquipoLocal();
}
