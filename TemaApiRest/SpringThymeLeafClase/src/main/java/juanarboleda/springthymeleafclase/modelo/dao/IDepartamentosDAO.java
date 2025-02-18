package juanarboleda.springthymeleafclase.modelo.dao;

import juanarboleda.springthymeleafclase.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamentosDAO extends CrudRepository<EntidadDepartamentos, Integer> {

}
