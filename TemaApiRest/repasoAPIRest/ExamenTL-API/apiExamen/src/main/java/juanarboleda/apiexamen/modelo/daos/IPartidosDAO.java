package juanarboleda.apiexamen.modelo.daos;

import juanarboleda.apiexamen.modelo.entidades.EntidadPartidos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPartidosDAO extends CrudRepository<EntidadPartidos, Integer> {

    @Query("SELECT p FROM EntidadPartidos p WHERE p.golesLocal > p.golesVisitante")
    List<EntidadPartidos> findPartidosGanadosPorEquipoLocal();
}
