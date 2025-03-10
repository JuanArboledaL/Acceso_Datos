package juanarboleda.ultimorepaso.controlador;

import juanarboleda.ultimorepaso.modelo.entidades.EntidadPartidos;
import juanarboleda.ultimorepaso.servicio.ServicioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/partido")
public class ControladorPartido {

    @Autowired
    ServicioPartido servicioPartido;

    @GetMapping("/{nombreEquipo}")
    public Set<EntidadPartidos> buscarPartidosByEquipo(@PathVariable(value = "nombreEquipo")String equipo) {

        return servicioPartido.buscarPartidosByEquipo(equipo);
    }

    @GetMapping
    public List<EntidadPartidos> mostrarPartidosGanadosByEquipoLocal(){

        return servicioPartido.mostrarPartidosGanadosByEquipoLocal();
    }
}
