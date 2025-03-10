package juanarboleda.ultimorepaso.controlador;

import juanarboleda.ultimorepaso.modelo.entidades.EntidadEquipos;
import juanarboleda.ultimorepaso.servicio.ServicioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipo")
public class ControladorEquipo {

    @Autowired
    ServicioEquipo servicioEquipo;

    @GetMapping
    public List<EntidadEquipos> busquedaEquipos(){

        return servicioEquipo.buscarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<EntidadEquipos> busquedaEquiposPorId(@PathVariable (value = "id")int id){

        return servicioEquipo.buscarEquipoById(id);
    }

    @PostMapping
    public EntidadEquipos guardarEquipo(@RequestBody EntidadEquipos entidadEquipos){

        return servicioEquipo.crearEquipo(entidadEquipos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipo(@PathVariable (value = "id")int id){

        if(servicioEquipo.eliminarEquipo(id)){
            return ResponseEntity.ok().body("Equipo eliminado correctamente");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEquipo(@PathVariable (value = "id")int id,@RequestBody EntidadEquipos entidadEquipos){

        if(servicioEquipo.modificarEquipo(entidadEquipos,id)){

            return ResponseEntity.ok().body("Equipo modificado correctamente");
        }else{
            return ResponseEntity.badRequest().build();
        }

    }
}
