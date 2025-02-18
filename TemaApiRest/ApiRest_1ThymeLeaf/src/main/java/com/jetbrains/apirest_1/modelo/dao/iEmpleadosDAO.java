package com.jetbrains.apirest_1.modelo.dao;

import com.jetbrains.apirest_1.modelo.entidades.EntidadEmpleados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iEmpleadosDAO extends CrudRepository<EntidadEmpleados, Integer> {

    EntidadEmpleados findByPuesto(String puesto);
    //EntidadEmpleados findByDepnoGreaterThanEqual(int depno);

    EntidadEmpleados findByNombreStartingWith(String prefijo);

    EntidadEmpleados findByPuestoContaining(String puesto);

    List<EntidadEmpleados> findByPuestoContains(String puesto);

    @Query("select e from EntidadEmpleados e where e.nombre like %:patron%")
    EntidadEmpleados findByName(@Param("patron") String patron);



}
