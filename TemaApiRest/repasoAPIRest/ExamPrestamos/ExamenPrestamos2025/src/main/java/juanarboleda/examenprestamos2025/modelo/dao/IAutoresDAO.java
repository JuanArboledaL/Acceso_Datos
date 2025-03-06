package juanarboleda.examenprestamos2025.modelo.dao;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadAutores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoresDAO extends CrudRepository<EntidadAutores, Integer> {

}
