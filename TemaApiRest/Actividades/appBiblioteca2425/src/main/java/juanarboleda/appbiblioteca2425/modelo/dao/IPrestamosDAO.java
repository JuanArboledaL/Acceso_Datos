package juanarboleda.appbiblioteca2425.modelo.dao;

import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadPrestamos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrestamosDAO extends CrudRepository<EntidadPrestamos, Integer> {

}
