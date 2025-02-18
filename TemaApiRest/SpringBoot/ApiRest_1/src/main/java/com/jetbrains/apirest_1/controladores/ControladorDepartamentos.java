package com.jetbrains.apirest_1.controladores;

import com.jetbrains.apirest_1.modelo.entidades.EntidadDepartamentos;
import com.jetbrains.apirest_1.servicios.ServicioDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class ControladorDepartamentos {

    @Autowired
    ServicioDepartamentos servicioDepartamentos;

    @GetMapping
    public List<EntidadDepartamentos> buscarDepartamentos() {

        return servicioDepartamentos.buscarDepartamentos();

    }

    @GetMapping("/{id}")
    public Optional<EntidadDepartamentos> buscarDepartamentoPorId(@PathVariable(value = "id") int id) {

        return servicioDepartamentos.buscarDepartamentoPorCodigo(id);
    }

    @PostMapping
    public ResponseEntity<?> guardarDepartamento(@Validated @RequestBody EntidadDepartamentos departamento) {

        if(servicioDepartamentos.guardarDepartamento(departamento)) {

            return ResponseEntity.ok().body("Departamento guardado correctamente");
        }else{

            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarDepartamentos(@PathVariable (value = "id") int id){

        if(servicioDepartamentos.eliminarDepartamento(id)){

            return ResponseEntity.ok().body("Departamento eliminado correctamente");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDepartamento(@RequestBody EntidadDepartamentos nuevoDepartamento, @PathVariable (value = "id") int id){

        if (servicioDepartamentos.actualizarDepartamento(nuevoDepartamento)) {

            return ResponseEntity.ok().body("Departamento actualizado correctamente");
        }else{

            return ResponseEntity.badRequest().build();
        }
    }


}
