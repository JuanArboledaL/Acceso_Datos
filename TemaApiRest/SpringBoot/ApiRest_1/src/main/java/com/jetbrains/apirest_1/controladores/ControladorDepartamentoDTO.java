package com.jetbrains.apirest_1.controladores;

import com.jetbrains.apirest_1.servicios.ServicioDepartamentosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/departamentoDTO")
public class ControladorDepartamentoDTO {

    @Autowired
    ServicioDepartamentosDTO servicioDepartamentosDTO;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDepartamentoDTOPorId(@PathVariable Integer id) {

        if(servicioDepartamentosDTO.buscarDepartamentoDTOporId(id) != null){

            return ResponseEntity.ok().body(servicioDepartamentosDTO.buscarDepartamentoDTOporId(id));

        }else{

            return ResponseEntity.notFound().build();
        }
    }
}
