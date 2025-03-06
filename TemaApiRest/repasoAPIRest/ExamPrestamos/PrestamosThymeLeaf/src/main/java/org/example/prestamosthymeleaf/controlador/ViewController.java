package org.example.prestamosthymeleaf.controlador;

import org.example.prestamosthymeleaf.modelo.dao.IAutoresDAO;
import org.example.prestamosthymeleaf.modelo.dao.ILibrosDAO;
import org.example.prestamosthymeleaf.modelo.dao.IUsuariosDAO;
import org.example.prestamosthymeleaf.modelo.dao.IprestamosDAO;
import org.example.prestamosthymeleaf.modelo.entidades.EntidadAutores;
import org.example.prestamosthymeleaf.modelo.entidades.EntidadLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    IAutoresDAO autoresDAO;

    @Autowired
    ILibrosDAO librosDAO;
    @Autowired
    IprestamosDAO prestamosDAO;
    @Autowired
    IUsuariosDAO usuariosDAO;

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/verautores")
    public String verautores(Model model){

        model.addAttribute("autores", autoresDAO.findAll());
        return "verautores";
    }

    @GetMapping("/verlibros")
    public String verlibros(Model model){
        model.addAttribute("libros", librosDAO.findAll());
        return "verlibros";
    }

    @GetMapping("/verlibro")
    public String verlibro(@RequestParam (value = "id", required = true) int id, Model model){

        Optional<EntidadLibros> libro = librosDAO.findById(id);

        if(libro.isPresent()){
            model.addAttribute("libro", libro.get());
            return "verlibro";
        }else {

            model.addAttribute("Titulo", "Error" );
            return "error";

        }
    }

    @GetMapping("/verusuarios")
    public String verusuarios(Model model){
        model.addAttribute("usuarios", usuariosDAO.findAll());
        return "verusuarios";
    }
    @GetMapping("/altaautor")
    public String altaa(Model model){
        model.addAttribute("autores",new EntidadAutores());
        return "altaautor";
    }

    @PostMapping("/altaautor")
    public String altaautor(@ModelAttribute EntidadAutores autor, Model model){

        autoresDAO.save(autor);
        model.addAttribute("tipo_operacion", "ok");
        model.addAttribute("mensaje", "Equipo creado correctamente");

        return "altaautor";
    }

}
