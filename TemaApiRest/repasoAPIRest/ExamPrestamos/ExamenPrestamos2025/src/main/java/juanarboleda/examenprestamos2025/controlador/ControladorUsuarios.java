package juanarboleda.examenprestamos2025.controlador;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadUsuarios;
import juanarboleda.examenprestamos2025.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuarios {

    @Autowired
    ServicioUsuarios servicioUsuarios;

    @GetMapping
    public List<EntidadUsuarios> buscarUsuarios(){

        return servicioUsuarios.buscarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<EntidadUsuarios> buscarUsuariosId(@PathVariable int id){

        return servicioUsuarios.buscarUsuariosId(id);
    }

}
