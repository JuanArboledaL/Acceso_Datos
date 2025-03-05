package org.example.apirest_thymeleaf.modelo.daos;

import org.example.apirest_thymeleaf.modelo.entidades.EntidadPartidos;
import org.springframework.data.repository.CrudRepository;

public interface IPartidosDAO extends CrudRepository<EntidadPartidos,Integer> {


}
