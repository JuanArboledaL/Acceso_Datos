package juanarboleda.appbiblioteca2425.modelo.dao;

import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadAutores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IAutoresDAO extends CrudRepository<EntidadAutores, Integer> {

    public List<EntidadAutores> buscarAutor();
    public Optional<EntidadAutores> buscarAutorPorId(int id);
    public EntidadAutores GuardarAutor(EntidadAutores entidadAutores);
    public ResponseEntity<?> BorrarAutor(int id);
    public ResponseEntity<?> actualizarAutor(@RequestBody EntidadAutores nuevoAutor, @PathVariable(value = "id") int id);


}
