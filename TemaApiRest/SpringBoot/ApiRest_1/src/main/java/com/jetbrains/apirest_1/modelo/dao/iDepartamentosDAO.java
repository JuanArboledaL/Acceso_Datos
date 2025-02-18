package com.jetbrains.apirest_1.modelo.dao;

import com.jetbrains.apirest_1.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iDepartamentosDAO extends CrudRepository<EntidadDepartamentos, Integer> {

    EntidadDepartamentos findByNombre(String nombre);
    EntidadDepartamentos findByUbicacion(String ubicacion);

    EntidadDepartamentos findByNombreIgnoreCase(String nombre);
    EntidadDepartamentos findByUbicacionIgnoreCase(String ubicacion);

}
