package juanarboleda.apirest1.modelo.dao;

import juanarboleda.apirest1.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamentosDAO extends CrudRepository<EntidadDepartamentos,Integer> {

    //1 oopción de busqueda por nombre
    EntidadDepartamentos findByNombre(String nombre);

    //2 opcion de busqueda por ubicación
    EntidadDepartamentos findByUbicacion(String ubicacion);

//    //3 Modificar los metodos anteriores (cambiando solo el nombre del metodo) para ignorar mayusculas y minusculas
    EntidadDepartamentos findByNombreIgnoreCase(String nombre);
    EntidadDepartamentos findByUbicacionIgnoreCase(String ubicacion);
//
//
    EntidadDepartamentos findByUbicacionOrUbicacion(String ubicacion, String ubicacion2);

}
