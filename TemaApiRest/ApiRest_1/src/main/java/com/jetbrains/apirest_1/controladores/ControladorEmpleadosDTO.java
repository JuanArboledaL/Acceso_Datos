package com.jetbrains.apirest_1.controladores;


import com.jetbrains.apirest_1.modelo.dto.EmpleadosDTO;
import com.jetbrains.apirest_1.servicios.ServicioEmpleadosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/empleados-DTO")
public class ControladorEmpleadosDTO {

    @Autowired
    ServicioEmpleadosDTO servicioEmpleadosDTO;

    public ResponseEntity<?> buscarEmpleadoDTOporId(@PathVariable("id") int id) {

       if(servicioEmpleadosDTO.buscarEmpleadoDTOporId(id) == null){

           return ResponseEntity.ok().body(servicioEmpleadosDTO.buscarEmpleadoDTOporId(id));
       }else{

           return ResponseEntity.ok().build();
       }
    }
}
