package juanarboleda.examenprestamos2025.controlador;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadLibros;
import juanarboleda.examenprestamos2025.servicios.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class ControladorLibros {

    @Autowired
    ServicioLibros servicioLibros;

    @GetMapping
    public List<EntidadLibros> buscarLibros(){

        return servicioLibros.buscarLibros();
    }

    @PostMapping
    public EntidadLibros guardarLibro(EntidadLibros libro){

        return servicioLibros.guardarLibro(libro);
    }
}
