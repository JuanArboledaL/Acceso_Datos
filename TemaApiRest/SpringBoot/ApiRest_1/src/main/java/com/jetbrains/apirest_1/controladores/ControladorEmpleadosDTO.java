package com.jetbrains.apirest_1.controladores;

import com.jetbrains.apirest_1.servicios.ServicioEmpleadosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/empleadosDTO")
public class ControladorEmpleadosDTO {

    @Autowired
    ServicioEmpleadosDTO servicioEmpleadosDTO;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEmpleadoDTOporId(@PathVariable("id") int id) {

        if(servicioEmpleadosDTO.buscarEmpleadoDTOporId(id) == null){

            return ResponseEntity.ok().body(servicioEmpleadosDTO.buscarEmpleadoDTOporId(id));
        }else{

            return ResponseEntity.ok().build();
        }
    }
}
