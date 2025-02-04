package juanarboleda.act1.modelo.dao;

import juanarboleda.act1.modelo.entidades.EntidadEmpleados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmpleadosDAO extends CrudRepository<EntidadEmpleados, Integer> {

    List<EntidadEmpleados> findByPuesto(String puesto);

    @Query("select e from EntidadEmpleados e where e.nombre like %:patron%")
    EntidadEmpleados findByName(@Param("patron") String patron);

    List<EntidadEmpleados> findByPuestoContains(String nombre);

    //Agregar un metodo de busqueda de empleador por nombre, especificando una cadena como prefijo
    EntidadEmpleados findByNombreStartingWith(String prefijo);

    //Agrega un metodo de busqueda de empleador por puesto. El puesto ha de contener una subcadena que se suministrara como parametro
    EntidadEmpleados findByNombreContaining(String subCadena);


}
