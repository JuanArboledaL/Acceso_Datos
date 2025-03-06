package juanarboleda.examenprestamos2025.modelo.dao;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadLibros;
import org.springframework.data.repository.CrudRepository;

public interface ILibrosDAO extends CrudRepository<EntidadLibros, Integer> {
}
