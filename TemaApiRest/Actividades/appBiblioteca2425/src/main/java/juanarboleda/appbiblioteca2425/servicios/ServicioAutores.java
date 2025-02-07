package juanarboleda.appbiblioteca2425.servicios;

import juanarboleda.appbiblioteca2425.modelo.dao.IAutoresDAO;
import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioAutores{

    @Autowired
    IAutoresDAO autoresDAO;

    public List<EntidadAutores> buscarAutor(){

        return (List<EntidadAutores>) autoresDAO.findAll();
    }

    public Optional<EntidadAutores> buscarAutorPorId(int id){

        return autoresDAO.findById(id);
    }

    public EntidadAutores guardarAutor(EntidadAutores entidadAutores){
        return autoresDAO.save(entidadAutores);
    }

    public ResponseEntity<?> borrarAutor(int id){
        Optional<EntidadAutores> autor = autoresDAO.findById(id);

        if(autor.isPresent()){
            autoresDAO.deleteById(id);
            return ResponseEntity.ok().build();
        }else{

            return ResponseEntity.notFound().build();
        }

    }
    public ResponseEntity<?> actualizarAutor(@RequestBody EntidadAutores nuevoAutor, @PathVariable(value = "id") int id){

        Optional<EntidadAutores> autor = autoresDAO.findById(id);

        if(autor.isPresent()){

            autor.get().setId(id);
            autor.get().setNombreAutor(nuevoAutor.getNombreAutor());
            autor.get().setPais(nuevoAutor.getPais());
            autoresDAO.save(autor.get());

            return ResponseEntity.ok().build();
        }else{

            return ResponseEntity.notFound().build();
        }
    }

}
