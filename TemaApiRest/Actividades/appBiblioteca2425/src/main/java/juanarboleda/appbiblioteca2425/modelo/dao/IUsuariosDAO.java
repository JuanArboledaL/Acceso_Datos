package juanarboleda.appbiblioteca2425.modelo.dao;

import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadUsuarios;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUsuariosDAO extends CrudRepository<EntidadUsuarios, Integer> {

    public List<EntidadUsuarios> buscarUsuarios();
    public Optional<EntidadUsuarios> buscarUsuarioPorId(int id);
}
