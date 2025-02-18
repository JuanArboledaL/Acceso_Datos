package com.jetbrains.apirest_1.servicios;

import com.jetbrains.apirest_1.modelo.dao.iDepartamentosDAO;
import com.jetbrains.apirest_1.modelo.entidades.EntidadDepartamentos;
import com.jetbrains.apirest_1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioDepartamentos {

    @Autowired
    private iDepartamentosDAO departamentosDAO;

    public List<EntidadDepartamentos> buscarDepartamentos() {
        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    public Optional<EntidadDepartamentos> buscarDepartamentoPorCodigo(@PathVariable(value = "id") int id) {

        Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(id);

        return departamento;
    }

    public boolean guardarDepartamento(@Validated @RequestBody EntidadDepartamentos departamento) {

        Optional<EntidadDepartamentos> departament = departamentosDAO.findById(departamento.getId());

        if(departament.isPresent()) {

            return false;

        }else{

            departamentosDAO.save(departamento);
            return true;

        }
    }

    public boolean eliminarDepartamento(@PathVariable(value = "id") int id) {

        if(departamentosDAO.existsById(id)){
            departamentosDAO.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarDepartamento(@Validated @RequestBody EntidadDepartamentos departamento) {

        Optional<EntidadDepartamentos> departamentos = departamentosDAO.findById(departamento.getId());

        if(departamentos.isPresent()) {

            departamentos.get().setNombre(departamento.getNombre());
            departamentos.get().setEmpleados(departamento.getEmpleados());
            departamentos.get().setUbicacion(departamento.getUbicacion());
            departamentosDAO.save(departamentos.get());
            return true;

        } else {
            return false;
        }
    }
}
