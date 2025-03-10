package juanarboleda.thymeultimo.controlador;

import juanarboleda.thymeultimo.modelo.dao.IEquipoDAO;
import juanarboleda.thymeultimo.modelo.dao.IJugadorDAO;
import juanarboleda.thymeultimo.modelo.dao.IPartidosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    @Autowired
    IEquipoDAO equipoDAO;

    @Autowired
    IPartidosDAO partidosDAO;

    @Autowired
    IJugadorDAO jugadoresDAO;

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/verequipo")
    public String verEquipo(Model model) {
        model.addAttribute("equipos", equipoDAO.findAll());
        return "verequipo";

    }

    
}
