package juanarboleda.springthymeleafclase.modelo.dao;

import juanarboleda.springthymeleafclase.modelo.entidades.EntidadDepartamentos;
import juanarboleda.springthymeleafclase.modelo.entidades.EntidadEmpleados;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IEmpleadosDAO extends CrudRepository<EntidadEmpleados, Integer> {


    Object findAllByDepno(Optional<EntidadDepartamentos> byId);
}
