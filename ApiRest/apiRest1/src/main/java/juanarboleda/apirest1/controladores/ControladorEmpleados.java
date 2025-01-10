package juanarboleda.apirest1.controladores;

import juanarboleda.apirest1.modelo.dao.IEmpleadosDAO;
import juanarboleda.apirest1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api-rest/empleados")

public class ControladorEmpleados {

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @GetMapping
    public List<EntidadEmpleados> obtenerEmpleados(){
    }

    @GetMapping("/{id}")
    public ResponseEntity <EntidadEmpleados> buscarEmpleadosPorId(@PathVariable (value = "id") int id){

    }

    @PostMapping
    public EntidadEmpleados guardarEmpleados (@Validated @RequestBody EntidadEmpleados empleados){

    }
}
