package juanarboleda.apiexamen.controladores;

import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import juanarboleda.apiexamen.servcios.ServicioEntidadEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipo")
public class ControladorEquipo {

    @Autowired
    ServicioEntidadEquipos servicioEntidadEquipos;

    @GetMapping
    public List<EntidadEquipos> listarEquipos() {

        return servicioEntidadEquipos.buscarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<EntidadEquipos> buscarEquipoId(@PathVariable(value = "id") int id) {
        return servicioEntidadEquipos.buscarEquipoById(id);
    }

    @PostMapping
    public EntidadEquipos crearEquipo(@RequestBody EntidadEquipos equipo) {

        return servicioEntidadEquipos.guardarEquipo(equipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipo(@PathVariable(value = "id") int id) {

        if(servicioEntidadEquipos.buscarEquipoById(id) != null) {

            servicioEntidadEquipos.borrarEquipo(id);
            return ResponseEntity.ok().body("Se ha eliminado el equipo correctamente" );
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEquipo(@PathVariable(value = "id") int id, @RequestBody EntidadEquipos equipo) {

        if(servicioEntidadEquipos.buscarEquipoById(id) != null) {

            servicioEntidadEquipos.actualizarEquipo(equipo, id);
            return ResponseEntity.ok().body("Equipo actualizado correctamente");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
