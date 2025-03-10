package juanarboleda.ultimorepaso.controlador;

import juanarboleda.ultimorepaso.modelo.entidades.EntidadJugadores;
import juanarboleda.ultimorepaso.servicio.ServicioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("jugador")
public class ControladorJugador {

    @Autowired
    ServicioJugador servicioJugador;

    @GetMapping("/{nombre}")
    public Set<EntidadJugadores> buscarJugadorByNombreEquipo(@PathVariable (value= "nombre") String nombre) {

        return servicioJugador.buscarJugadorByNombreEquipo(nombre);
    }

    @PostMapping
    public EntidadJugadores crearJugadorValidado(@RequestBody EntidadJugadores entidadJugador) {

        return servicioJugador.crearJugadorValidado(entidadJugador);
    }

    @GetMapping
    public List<EntidadJugadores> buscarJugador() {
        return servicioJugador.buscarJugadores();
    }
}
