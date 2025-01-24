package juanarboleda.apirest1.modelo.dao;

import juanarboleda.apirest1.modelo.entidades.EntidadDepartamentos;
import juanarboleda.apirest1.modelo.entidades.EntidadEmpleados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadosDAO extends CrudRepository<EntidadEmpleados,Integer> {

    EntidadEmpleados findByNombre(String nombre);
//    EntidadEmpleados findByDepnoGreaterThanEqual(int depno);

   //Agregar un metodo de busqueda de empleador por nombre, especificando una cadena como prefijo
//    EntidadEmpleados findByNombreStartingWith(String prefijo);

    //Agrega un metodo de busqueda de empleador por puesto. El puesto ha de contener una subcadena que se suministrara como parametro
   List<EntidadEmpleados> findByPuestoContaining(String nombre);

    @Query ("select e from EntidadDepartamentos e where e.nombre like %:patron%")
    EntidadDepartamentos findByPatron(@Param("patron") String patron);

}
