package com.jetbrains.apirest_1.controladores;

import com.jetbrains.apirest_1.modelo.entidades.EntidadEmpleados;
import com.jetbrains.apirest_1.servicios.ServicioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class ControladorEmpleados {

    @Autowired
    ServicioEmpleados servicioEmpleados;


    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados(@RequestParam(name = "puesto", required = false) String puesto) {

        if (puesto == null) {
            return servicioEmpleados.buscarEmpleados();
        }
        else{
            return servicioEmpleados.buscarEmpleadosPorPuesto(puesto);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadEmpleados> buscarEmpleadosPorId(@PathVariable("id") int id) {

        return servicioEmpleados.buscarEmpleadosPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> guardarEmpleados(@RequestBody @Validated EntidadEmpleados empleado){

        if(servicioEmpleados.guardarEmpleados(empleado)){

            return ResponseEntity.ok().body("empleado guardado correctamente");

        }else{

            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEmpleados(@PathVariable("id") int id) {

        if(servicioEmpleados.borrarEmpleado(id)){

            return ResponseEntity.ok().body("empleado borrado correctamente");

        }else{

            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleados(@PathVariable("id") int id, @RequestBody EntidadEmpleados empleado) {

        if(servicioEmpleados.actualizarEmpleado(id, empleado)){

            return ResponseEntity.ok().body("empleado actualizado correctamente");

        }else{

            return ResponseEntity.badRequest().build();
        }
    }


}
