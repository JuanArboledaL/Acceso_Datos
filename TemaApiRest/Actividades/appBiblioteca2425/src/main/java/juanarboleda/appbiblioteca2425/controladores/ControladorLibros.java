package juanarboleda.appbiblioteca2425.controladores;

import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadLibros;
import juanarboleda.appbiblioteca2425.servicios.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api-rest/libros")
public class ControladorLibros {

    @Autowired
    ServicioLibros servicioLibros;

    @GetMapping
    public List<EntidadLibros> buscarLibros(){
        return servicioLibros.buscarLibros();
    }

    @PostMapping
    public void guardarLibros(EntidadLibros libro) {

        servicioLibros.guardarLibro(libro);
    }
}
