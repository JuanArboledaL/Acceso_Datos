package juanarboleda.examenprestamos2025.servicios;

import juanarboleda.examenprestamos2025.modelo.dao.ILibrosDAO;
import juanarboleda.examenprestamos2025.modelo.entidades.EntidadLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioLibros {

    @Autowired
    ILibrosDAO librosDAO;

    public List<EntidadLibros> buscarLibros(){

        return (List<EntidadLibros>) librosDAO.findAll();
    }

    public EntidadLibros guardarLibro(EntidadLibros libro){

        return librosDAO.save(libro);
    }
}
