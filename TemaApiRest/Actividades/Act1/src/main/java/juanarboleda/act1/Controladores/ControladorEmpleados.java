package juanarboleda.act1.Controladores;

import juanarboleda.act1.modelo.dao.IDepartamentosDAO;
import juanarboleda.act1.modelo.dao.IEmpleadosDAO;
import juanarboleda.act1.modelo.dto.EmpleadosDTO;
import juanarboleda.act1.modelo.entidades.EntidadDepartamentos;
import juanarboleda.act1.modelo.entidades.EntidadEmpleados;
import juanarboleda.act1.servicios.ServicioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class ControladorEmpleados {

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @Autowired
    IDepartamentosDAO departamentosDAO;

    @Autowired
    ServicioEmpleados servicioEmpleados;


    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados(@RequestParam(name = "puesto",required = false) String puesto){

        if(puesto == null){

            return servicioEmpleados.buscarEmpleados();

        }else{
            return servicioEmpleados.buscarEmpleadosPorPuesto(puesto);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleados (@PathVariable (value = "id") int id){

        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if(empleado.isPresent()){
            empleadosDAO.deleteById(id);
            return ResponseEntity.ok().build();
        }else{

            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@RequestBody EntidadEmpleados nuevoEmpleado, @PathVariable (value = "id") int id){

        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if(empleado.isPresent()){

            empleado.get().setNombre(nuevoEmpleado.getNombre());
            empleado.get().setPuesto(nuevoEmpleado.getPuesto());
            empleado.get().setDepno(nuevoEmpleado.getDepno());
            empleadosDAO.save(empleado.get());

            return ResponseEntity.ok().build();
        }else{

            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<EmpleadosDTO> buscarEmpleadoDTOPorId(@PathVariable (value = "id") int id){

        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if(empleado.isPresent()){

            Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(empleado.get().getDepno().getId());

            EmpleadosDTO empleadosDTO = new EmpleadosDTO();
            empleadosDTO.setEmpno(empleado.get().getId());
            empleadosDTO.setNombre(empleado.get().getNombre());
            empleadosDTO.setPuesto(empleado.get().getPuesto());
            empleadosDTO.setDepno(departamento.get().getId());
            empleadosDTO.setDepartamentoNombre(departamento.get().getNombre());
            empleadosDTO.setDepartamentoUbicacion(departamento.get().getUbicacion());
            return ResponseEntity.ok(empleadosDTO);

        }
        else{

            return ResponseEntity.notFound().build();
        }
    }

}
