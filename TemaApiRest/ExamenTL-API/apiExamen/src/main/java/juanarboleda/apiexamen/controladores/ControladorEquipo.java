package juanarboleda.apiexamen.controladores;

import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import juanarboleda.apiexamen.servcios.ServicioEntidadEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
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

//        if(servicioEntidadEquipos.guardarEquipo(equipo)){
//
//            return ResponseEntity.ok().body("Se ha guardado correctamente el equipo");
//        }else{
//
//            return ResponseEntity.badRequest().build();
//        }
        return servicioEntidadEquipos.guardarEquipo(equipo);


    }
}
