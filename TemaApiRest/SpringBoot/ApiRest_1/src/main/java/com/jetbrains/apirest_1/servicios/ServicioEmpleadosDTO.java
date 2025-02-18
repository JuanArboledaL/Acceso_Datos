package com.jetbrains.apirest_1.servicios;

import com.jetbrains.apirest_1.modelo.dao.iDepartamentosDAO;
import com.jetbrains.apirest_1.modelo.dao.iEmpleadosDAO;
import com.jetbrains.apirest_1.modelo.dto.EmpleadosDTO;
import com.jetbrains.apirest_1.modelo.entidades.EntidadDepartamentos;
import com.jetbrains.apirest_1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ServicioEmpleadosDTO {

    @Autowired
    iEmpleadosDAO empleadosDAO;

    @Autowired
    iDepartamentosDAO departamentosDAO;

    @GetMapping("dto/{id}")
    public ResponseEntity<EmpleadosDTO> buscarEmpleadoDTOporId(@PathVariable(value = "id") int id){
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if (empleado.isPresent()){
            Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(empleado.get().getDepno().getId());

            EmpleadosDTO empleadoDTO = new EmpleadosDTO();
            empleadoDTO.setEmpno(empleado.get().getId());
            empleadoDTO.setNombre(empleado.get().getNombre());
            empleadoDTO.setPuesto(empleado.get().getPuesto());
            empleadoDTO.setDepno(empleado.get().getDepno().getId());
            empleadoDTO.setDepartamentoNombre(departamento.get().getNombre());
            empleadoDTO.setDepartamentoUbicacion(departamento.get().getUbicacion());

//            ModelMapper mapper = new ModelMapper();
//
//            EmpleadosDTO empleadosDTO = mapper.map(empleado.get(), EmpleadosDTO.class);
//            mapper.map(departamento.get(), empleadosDTO);

            return ResponseEntity.ok().body(empleadoDTO);

        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
