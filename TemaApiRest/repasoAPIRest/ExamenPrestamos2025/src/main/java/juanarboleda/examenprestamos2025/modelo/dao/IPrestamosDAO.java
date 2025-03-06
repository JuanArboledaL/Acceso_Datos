package juanarboleda.examenprestamos2025.modelo.dao;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadPrestamos;
import org.springframework.data.repository.CrudRepository;

public interface IPrestamosDAO extends CrudRepository<EntidadPrestamos,Integer> {
}
