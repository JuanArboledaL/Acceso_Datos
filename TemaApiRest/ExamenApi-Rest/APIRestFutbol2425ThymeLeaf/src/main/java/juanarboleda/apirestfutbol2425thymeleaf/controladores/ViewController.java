package juanarboleda.apirestfutbol2425thymeleaf.controladores;

import juanarboleda.apirestfutbol2425thymeleaf.servicios.ServicioEquipos;
import juanarboleda.apirestfutbol2425thymeleaf.servicios.ServicioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
public class ViewController {

    @Autowired
    ServicioEquipos servicioEquipo;

    @Autowired
    ServicioJugador servicioJugador;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/verequipos")
    public String buscarEquipos() {

        servicioEquipo.buscarEquipos();
        return("verequipos");
    }

    @GetMapping("/verjugadores")
    public String verjugadores() {

        servicioJugador.listarEntidadJugadores();
        return("verjugadores");
    }

    @GetMapping("/verjugador")
    public String verjugador(@PathVariable(value = "id") int id) {

        servicioJugador.buscarJugador(id);
        return("verjugador");
    }

}
