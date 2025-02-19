package juanarboleda.apirestfutbol2425thymeleaf.modelo.daos;

import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadPartidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidosDAO extends CrudRepository<EntidadPartidos, Integer> {
}
