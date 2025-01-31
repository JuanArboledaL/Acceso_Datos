package juanarboleda.act1.modelo.dao;

import juanarboleda.act1.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentosDAO extends CrudRepository<EntidadDepartamentos,Integer> {

    //Busqueda por nombre
    EntidadDepartamentos findByNombreIgnoreCase(String nombre);

    //Busqueda por ubicación
    EntidadDepartamentos findByUbicacionIgnoreCase(String ubicacion);




}
