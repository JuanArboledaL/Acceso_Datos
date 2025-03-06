package org.example.prestamosthymeleaf.modelo.dao;

import org.example.prestamosthymeleaf.modelo.entidades.EntidadPrestamos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IprestamosDAO extends CrudRepository<EntidadPrestamos, Integer> {

}
