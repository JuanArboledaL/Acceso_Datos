package com.jetbrains.apirest_1.servicios;

import com.jetbrains.apirest_1.modelo.dao.iDepartamentosDAO;
import com.jetbrains.apirest_1.modelo.dao.iEmpleadosDAO;
import com.jetbrains.apirest_1.modelo.dto.DepartamentoDTO;
import com.jetbrains.apirest_1.modelo.entidades.EntidadDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ServicioDepartamentosDTO {

    @Autowired
    iDepartamentosDAO departamentosDAO;

    public ResponseEntity<DepartamentoDTO> buscarDepartamentoDTOporId(@PathVariable(value = "id") int id){

        Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(id);

        if (departamento.isPresent()){

            DepartamentoDTO departamentoDTO = new DepartamentoDTO();
            departamentoDTO.setDepno(departamento.get().getId());
            departamentoDTO.setNombre(departamento.get().getNombre());
            departamentoDTO.setUbicacion(departamento.get().getUbicacion());

            return ResponseEntity.ok().body(departamentoDTO);

        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
