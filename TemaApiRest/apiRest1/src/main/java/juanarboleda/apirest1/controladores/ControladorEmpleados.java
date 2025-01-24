package juanarboleda.apirest1.controladores;

import juanarboleda.apirest1.Servicios.ServicioEmpleados;
import juanarboleda.apirest1.modelo.dao.IDepartamentosDAO;
import juanarboleda.apirest1.modelo.dao.IEmpleadosDAO;
import juanarboleda.apirest1.modelo.dto.EmpleadosDTO;
import juanarboleda.apirest1.modelo.entidades.EntidadDepartamentos;
import juanarboleda.apirest1.modelo.entidades.EntidadEmpleados;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/empleados")
public class ControladorEmpleados {

    @Autowired
    ServicioEmpleados servicioEmpleados;

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @Autowired
    IDepartamentosDAO departamentosDAO;

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
    public ResponseEntity<?> guardarEmpleados (@Validated @RequestBody EntidadEmpleados empleados){

        if(!empleadosDAO.existsById(empleados.getId())){

            return ResponseEntity.ok().body(empleadosDAO.save(empleados));
        }else{

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable (value = "id") int id){
        if(empleadosDAO.existsById(id)){
            empleadosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@RequestBody EntidadEmpleados nuevoEmpleado, @PathVariable (value = "id") int id){
        if(empleadosDAO.existsById(id)){
            empleadosDAO.save(nuevoEmpleado);
            return ResponseEntity.ok().body("Actualizado");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("dto/{id}")
    public ResponseEntity<EmpleadosDTO> buscarEmpleadosDTOById(@PathVariable(value = "id") int id){
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if(empleado.isPresent()){

            Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(empleado.get().getDepno().getId());

            EmpleadosDTO empleadosDTO = new EmpleadosDTO();
            empleadosDTO.setEmpno(empleado.get().getId());
            empleadosDTO.setNombre(empleado.get().getNombre());
            empleadosDTO.setPuesto(empleado.get().getPuesto());
            empleadosDTO.setDepno(empleado.get().getDepno().getId());
            empleadosDTO.setDepartamentoNombre(departamento.get().getNombre());
            empleadosDTO.setDepartamentoUbicacion(departamento.get().getUbicacion());
//            ModelMapper mapper = new ModelMapper();
//
//            EmpleadosDTO empleadosDTO = mapper.map(empleado.get(), EmpleadosDTO.class);
//            mapper.map(departamento.get(),empleadosDTO);


            return ResponseEntity.ok().body(empleadosDTO);

        }else{

            return ResponseEntity.notFound().build();

        }
    }



}
