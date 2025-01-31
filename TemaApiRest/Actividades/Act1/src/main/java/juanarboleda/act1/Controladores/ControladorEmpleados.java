package juanarboleda.act1.Controladores;

import juanarboleda.act1.modelo.dao.IEmpleadosDAO;
import juanarboleda.act1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empledos")
public class ControladorEmpleados {

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados(@RequestParam(name = "puesto",required = false) String puesto){

        if(puesto == null){
            return (List<EntidadEmpleados>) empleadosDAO.findAll();
        }else{
            return (List<EntidadEmpleados>) empleadosDAO.findByPuestoContains(puesto);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <EntidadEmpleados> buscarEmpleadosPorId(@PathVariable (value = "id") int id){

        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if(empleado.isPresent()){

            return ResponseEntity.ok().body(empleado.get());

        }else{

            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EntidadEmpleados guardarEmpleados (@Validated @RequestBody EntidadEmpleados empleado){

        return empleadosDAO.save(empleado);
    }






}
