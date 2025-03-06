package org.example.prestamosthymeleaf.modelo.dao;

import org.example.prestamosthymeleaf.modelo.entidades.EntidadAutores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoresDAO extends CrudRepository<EntidadAutores, Integer> {

}
