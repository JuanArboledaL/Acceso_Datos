package juanarboleda.apiexamen.controladores;

import juanarboleda.apiexamen.modelo.entidades.EntidadJugadores;
import juanarboleda.apiexamen.servcios.ServicioJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
