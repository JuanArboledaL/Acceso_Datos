package juanarboleda.appbiblioteca2425.modelo.dao;

import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadUsuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuariosDAO extends CrudRepository<EntidadUsuarios, Integer> {


}
