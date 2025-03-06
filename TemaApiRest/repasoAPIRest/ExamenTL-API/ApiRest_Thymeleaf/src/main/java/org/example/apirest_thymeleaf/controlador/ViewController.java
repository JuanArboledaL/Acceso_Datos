package org.example.apirest_thymeleaf.controlador;

import org.example.apirest_thymeleaf.modelo.daos.IEquiposDAO;
import org.example.apirest_thymeleaf.modelo.daos.IPartidosDAO;
import org.example.apirest_thymeleaf.modelo.daos.IjugadoresDAO;
import org.example.apirest_thymeleaf.modelo.entidades.EntidadEquipos;
import org.example.apirest_thymeleaf.modelo.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class ViewController {

    @Autowired
    IEquiposDAO equiposDAO;

    @Autowired
    IjugadoresDAO ijugadoresDAO;

    @Autowired
    IPartidosDAO partidosDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/verequipos")
    public String verequipos(Model model) {
        model.addAttribute("equipos", equiposDAO.findAll());
        return "verequipos";
    }

    @GetMapping("/verjugadores")
    public String verjugadores(Model model) {
        model.addAttribute("jugadores", ijugadoresDAO.findAll());
        return "verjugadores";
    }

    @GetMapping("/verjugador")
    public String verJugador(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<EntidadJugadores> jugador = ijugadoresDAO.findById(id);

        if(jugador.isPresent()) {
            model.addAttribute("jugador", jugador.get());
            return "verjugador";
        }else{

            model.addAttribute("titulo", "Error");
            return "error";
        }

    }

    @GetMapping("/verpartidos")
    public String verpartidos(Model model) {
        model.addAttribute("partidos", partidosDAO.findAll());
        return "verpartidos";
    }

    @GetMapping("/altaequipo")
    public String altaEquipo(Model model) {

        model.addAttribute("equipos", new EntidadEquipos());
        return "altaequipo";
    }

    @PostMapping("/altaequipo")
    public String crarEquipo(@ModelAttribute EntidadEquipos equipo, Model model) {

        equiposDAO.save(equipo);
        model.addAttribute("tipo_operacion", "ok");
        model.addAttribute("mensaje", "Equipo creado correctamente");

        return "altaequipo";
    }

    

}
