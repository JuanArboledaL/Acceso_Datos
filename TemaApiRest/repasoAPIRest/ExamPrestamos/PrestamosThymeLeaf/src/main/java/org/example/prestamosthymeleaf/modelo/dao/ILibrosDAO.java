package org.example.prestamosthymeleaf.modelo.dao;

import org.example.prestamosthymeleaf.modelo.entidades.EntidadLibros;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibrosDAO extends CrudRepository<EntidadLibros, Integer> {

}
