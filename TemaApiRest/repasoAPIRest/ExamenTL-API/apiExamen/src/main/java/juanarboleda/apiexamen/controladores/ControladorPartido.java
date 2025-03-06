package juanarboleda.apiexamen.controladores;

import juanarboleda.apiexamen.modelo.entidades.EntidadPartidos;
import juanarboleda.apiexamen.servcios.ServicioPartido;
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

    @GetMapping("/{nombre}")
    public Set<EntidadPartidos> mostrarPartidoByEquipo(@PathVariable (value = "nombre") String nombre) {

        return servicioPartido.mostrarPartidoByEquipo(nombre);
    }

    @GetMapping("/local")
    public List<EntidadPartidos> buscarPartidosGanadosPorLocal() {
        return servicioPartido.buscarPartidosGanadosLocal();
    }
}
