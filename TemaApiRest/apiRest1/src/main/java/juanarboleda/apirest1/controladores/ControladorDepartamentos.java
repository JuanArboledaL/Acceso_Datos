package juanarboleda.apirest1.controladores;

import juanarboleda.apirest1.modelo.dao.IDepartamentosDAO;
import juanarboleda.apirest1.modelo.dao.IEmpleadosDAO;
import juanarboleda.apirest1.modelo.dto.DepartamentosDTO;
import juanarboleda.apirest1.modelo.dto.EmpleadosDTO;
import juanarboleda.apirest1.modelo.entidades.EntidadDepartamentos;
import juanarboleda.apirest1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/empleados")
public class ControladorDepartamentos {


    @Autowired
    IDepartamentosDAO departamentosDAO;

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @GetMapping
    public List<EntidadDepartamentos> buscarDepartamento(@RequestParam(name = "puesto",required = false) String puesto){

        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadDepartamentos> buscarDepartamentosPorId(@PathVariable(value = "id") int id){

        Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(id);

        if(departamento.isPresent()){

            return ResponseEntity.ok(departamento.get());

        }else{

            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EntidadDepartamentos guardarDepartamentos (@Validated @RequestBody EntidadDepartamentos departamento){

        return departamentosDAO.save(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarDepartamento(@PathVariable (value = "id") int id){
        if(departamentosDAO.existsById(id)){
            departamentosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actuaizarDepartamento(@RequestBody EntidadDepartamentos nuevoDepartaento, @PathVariable (value = "id") int id){
        if(departamentosDAO.existsById(id)){
            departamentosDAO.save(nuevoDepartaento);
            return ResponseEntity.ok().body("Actualizado");
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("dto/{id}")
    public ResponseEntity<DepartamentosDTO> buscarDepartamentoById(@PathVariable(value = "id") int id){
        Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(id);

        if(departamento.isPresent()){

            //Optional<EntidadEmpleados> empleados = empleadosDAO.findById(departamentos.get().getDepNo());

            DepartamentosDTO departamentosDTO = new DepartamentosDTO();

            departamentosDTO.setNombre(departamento.get().getNombre());
            departamentosDTO.setUbicacion(departamento.get().getUbicacion());
            departamentosDTO.setDepNo(departamento.get().getId());
//            ModelMapper mapper = new ModelMapper();
//
//            EmpleadosDTO empleadosDTO = mapper.map(empleado.get(), EmpleadosDTO.class);
//            mapper.map(departamento.get(),empleadosDTO);


            return ResponseEntity.ok().body(departamentosDTO);

        }else{

            return ResponseEntity.notFound().build();

        }
    }
}
