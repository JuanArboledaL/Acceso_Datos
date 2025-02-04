package juanarboleda.appbiblioteca2425.servicios;

import juanarboleda.appbiblioteca2425.modelo.dao.ILibrosDAO;
import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ServicioLibros  {

    @Autowired
    ILibrosDAO librosDAO;

    public List<EntidadLibros> buscarLibros(){

        List<EntidadLibros> libros = librosDAO.buscarLibros();

        return libros;
    }

    public ResponseEntity<?> guardarLibro(EntidadLibros libro){

        librosDAO.guardarLibros(libro);
        return ResponseEntity.ok().build();
    }
}
