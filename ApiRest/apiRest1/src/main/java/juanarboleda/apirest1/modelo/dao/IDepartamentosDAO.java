package juanarboleda.apirest1.modelo.dao;

import juanarboleda.apirest1.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartamentosDAO extends CrudRepository<EntidadDepartamentos,Integer> {

    //1 oopción de busqueda por nombre
    List <EntidadDepartamentos> findByNombre(String nombre);

    //2 opcion de busqueda por ubicación
    List <EntidadDepartamentos> findByUbicacion(String ubicacion);

    //3 Modificar los metodos anteriores (cambiando solo el nombre del metodo) para ignorar mayusculas y minusculas
    List <EntidadDepartamentos> findByNombreIgnoreCase(String nombre);
    List <EntidadDepartamentos> findByUbicacionIgnoreCase(String ubicacion);

    List<EntidadDepartamentos> findByUbicacionOrUbicacion(String ubicacion, String ubicacion2);


}
