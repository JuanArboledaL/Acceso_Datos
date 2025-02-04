package juanarboleda.appbiblioteca2425.controladores;

import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadAutores;
import juanarboleda.appbiblioteca2425.servicios.ServicioAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api-rest/empleados")
public class ControladorAutores{

    @Autowired
    ServicioAutores servicioAutores;

    @GetMapping
    public List<EntidadAutores> listaAutores() {

        return servicioAutores.buscarAutor();

    }

    @GetMapping("{id}")
    public Optional<EntidadAutores> buscarAutor(@PathVariable int id) {

        return servicioAutores.buscarAutorPorId(id);
    }

    @PostMapping
    public EntidadAutores guardarAutor(@RequestBody EntidadAutores entidadAutores) {

        servicioAutores.GuardarAutor(entidadAutores);

        return entidadAutores;
    }

    @DeleteMapping("{id}")
    public void borrarAutor(@PathVariable int id) {

        servicioAutores.BorrarAutor(id);

    }

    @PutMapping("{id}")
    public EntidadAutores actualizarAutor(@RequestBody EntidadAutores autor) {

        servicioAutores.actualizarAutor(autor, autor.getId());
        return autor;
    }



}
