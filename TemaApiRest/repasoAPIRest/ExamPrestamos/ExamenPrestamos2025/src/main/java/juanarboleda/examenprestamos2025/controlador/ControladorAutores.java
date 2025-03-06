package juanarboleda.examenprestamos2025.controlador;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadAutores;
import juanarboleda.examenprestamos2025.servicios.ServicioAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class ControladorAutores {

    @Autowired
    ServicioAutores servicioAutores;

    @GetMapping
    public List<EntidadAutores> buscarAutores() {

        return servicioAutores.buscarAutores();

    }
    @GetMapping("/{id}")
    public Optional<EntidadAutores> buscarAutorById(@PathVariable (value = "id")int id) {

        return servicioAutores.buscarAutorPorId(id);
    }

    @PostMapping
    public EntidadAutores guardarAutor(@RequestBody EntidadAutores entidadAutores) {

        return servicioAutores.guardarAutor(entidadAutores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAutor(@PathVariable (value = "id")int id) {

        if(servicioAutores.eliminarAutor(id)) {
            return ResponseEntity.ok().body("Autor eliminado correctamente");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAutor(@PathVariable (value = "id")int id, @RequestBody EntidadAutores entidadAutor) {

        if(servicioAutores.actualizarAutor(entidadAutor, id)) {

            return ResponseEntity.ok().body("Autor actualizado correctamente");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
