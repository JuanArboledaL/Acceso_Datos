package org.example.prestamosthymeleaf.modelo.dao;

import org.example.prestamosthymeleaf.modelo.entidades.EntidadUsuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosDAO extends CrudRepository<EntidadUsuarios, Integer> {


}
