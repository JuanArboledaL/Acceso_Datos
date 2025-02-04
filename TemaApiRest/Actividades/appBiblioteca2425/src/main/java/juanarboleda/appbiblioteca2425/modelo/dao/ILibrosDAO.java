package juanarboleda.appbiblioteca2425.modelo.dao;

import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadLibros;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILibrosDAO extends CrudRepository<EntidadLibros, Integer> {

    public List<EntidadLibros> buscarLibros();

    public void guardarLibros(EntidadLibros entidadLibros);
}
