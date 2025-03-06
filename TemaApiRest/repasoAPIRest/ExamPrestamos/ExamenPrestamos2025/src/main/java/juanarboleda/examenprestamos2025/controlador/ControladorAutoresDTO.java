package juanarboleda.examenprestamos2025.controlador;

import juanarboleda.examenprestamos2025.servicios.ServicioAutoresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores/dto")
public class ControladorAutoresDTO {

    @Autowired
    ServicioAutoresDTO servicioAutoresDTO;

}
