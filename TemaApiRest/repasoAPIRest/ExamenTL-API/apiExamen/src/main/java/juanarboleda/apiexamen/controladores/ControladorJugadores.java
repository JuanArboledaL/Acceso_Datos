package juanarboleda.apiexamen.controladores;

import juanarboleda.apiexamen.modelo.entidades.EntidadJugadores;
import juanarboleda.apiexamen.servcios.ServicioJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/jugador")
public class ControladorJugadores {

    @Autowired
    ServicioJugadores servicioJugadores;

    @GetMapping("/{nombreEquipo}")
    public Set<EntidadJugadores> buscarJugadorByNombreEquipo(@PathVariable(value = "nombreEquipo") String nombreEquipo) {

        return servicioJugadores.buscarJugadorByNombreEquipo(nombreEquipo);

    }

    @PostMapping
    public EntidadJugadores CrearJugadorValidado(@Validated @RequestBody EntidadJugadores jugador) {

        return servicioJugadores.CrearJugadorValidado(jugador);
    }

    @GetMapping
    public List<EntidadJugadores> listarJugadores() {

        return servicioJugadores.listarJugadores();
    }

}
