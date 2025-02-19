package juanarboleda.apirestfutbol2425.controladores;

import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import juanarboleda.apirestfutbol2425.servicios.ServicioEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipo")
public class ControladorEquipo {

    @Autowired
    ServicioEquipos servicioEquipo;

    @GetMapping
    public List<EntidadEquipos> buscarEquipos() {

        return servicioEquipo.buscarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<EntidadEquipos> buscarEquipoById(@PathVariable(value = "id") int id) {

        return servicioEquipo.buscarEquipoPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> crearEquipo(@Validated @RequestBody EntidadEquipos equipo) {

        if(servicioEquipo.crearEquipo(equipo)) {

            return ResponseEntity.ok().body("Se ha creado el equipo con exito");
        }else{

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipo(@PathVariable(value = "id") int id) {

        if(servicioEquipo.eliminarEquipo(id)){

            return ResponseEntity.ok().body("Se ha eliminado el equipo con exito");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEquipo(@RequestBody EntidadEquipos equipo) {

        if(servicioEquipo.modificarEquipo(equipo,equipo.getId())){

            return ResponseEntity.ok().body("Se ha modificado el equipo con exito");

        }else{

            return ResponseEntity.badRequest().build();
        }

    }
}
