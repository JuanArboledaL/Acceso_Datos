package org.example.apirest_thymeleaf.modelo.daos;

import org.example.apirest_thymeleaf.modelo.entidades.EntidadEquipos;
import org.springframework.data.repository.CrudRepository;

public interface IEquiposDAO extends CrudRepository<EntidadEquipos, Integer> {
}
