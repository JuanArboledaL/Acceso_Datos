package juanarboleda.examenprestamos2025.controlador;

import juanarboleda.examenprestamos2025.modelo.entidades.EntidadPrestamos;
import juanarboleda.examenprestamos2025.servicios.ServicioPrestamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class ControladoPrestamos {

    @Autowired
    ServicioPrestamos servicioPrestamos;

    @GetMapping
    public List<EntidadPrestamos> buscarPrestamos(){

        return servicioPrestamos.buscarPrestamo();
    }

    @PostMapping
    public EntidadPrestamos guardarPrestamo(@RequestBody EntidadPrestamos entidadPrestamos) {

        return servicioPrestamos.guardarPrestamos(entidadPrestamos);
    }
}
