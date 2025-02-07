package juanarboleda.appbiblioteca2425.controladores;

import juanarboleda.appbiblioteca2425.servicios.ServicioAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-rest/usuarios")
public class ControladoUsuarios {

    @Autowired
    ServicioAutores servicioAutores;


}
