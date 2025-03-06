package juanarboleda.examenprestamos2025.modelo.dao;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadUsuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDAO extends CrudRepository<EntidadUsuarios, Integer> {
}
