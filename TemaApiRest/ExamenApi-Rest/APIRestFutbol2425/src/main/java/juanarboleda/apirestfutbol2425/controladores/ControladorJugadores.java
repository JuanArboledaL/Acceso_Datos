package juanarboleda.apirestfutbol2425.controladores;

import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadJugadores;
import juanarboleda.apirestfutbol2425.servicios.ServicioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class ControladorJugadores {

    @Autowired
    ServicioJugador servicioJugador;

//    @GetMapping
//    public List<EntidadJugadores> buscarJugadorByNombreEquipo(String nombreEquipo) {
//
//        return servicioJugador.buscarJugadorByNombreEquipo(nombreEquipo);
//    }

//    @PostMapping
//    public ResponseEntity<?> CrearJugadorValidado(@RequestBody EntidadJugadores entidadJugador) {
//
//        if(servicioJugador.CrearJugadorValidado(entidadJugador)){
//
//            return ResponseEntity.ok().body("Se ha creado correctamente el jugador");
//        }else{
//
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
