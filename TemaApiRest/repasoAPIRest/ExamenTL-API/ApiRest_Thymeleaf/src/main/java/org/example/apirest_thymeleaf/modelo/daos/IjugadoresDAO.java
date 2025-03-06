package org.example.apirest_thymeleaf.modelo.daos;

import org.example.apirest_thymeleaf.modelo.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;

public interface IjugadoresDAO extends CrudRepository<EntidadJugadores, Integer> {
}
