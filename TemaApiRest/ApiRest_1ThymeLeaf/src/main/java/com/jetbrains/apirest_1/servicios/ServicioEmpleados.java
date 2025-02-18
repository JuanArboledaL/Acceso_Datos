package com.jetbrains.apirest_1.servicios;

import com.jetbrains.apirest_1.modelo.dao.iEmpleadosDAO;
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
public class ServicioEmpleados {

    @Autowired
    private iEmpleadosDAO empleadosDAO;

    public List<EntidadEmpleados> buscarEmpleados(){

        return (List<EntidadEmpleados>) empleadosDAO.findAll();
    }

    public ResponseEntity<EntidadEmpleados> buscarEmpleadosPorId(@PathVariable(value = "id") int id){

        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if(empleado.isPresent())

            return ResponseEntity.ok(empleado.get());
        else
            return ResponseEntity.notFound().build();
    }

    public List<EntidadEmpleados> buscarEmpleadosPorPuesto(String puesto){
        return empleadosDAO.findByPuestoContains(puesto);
    }

    public boolean guardarEmpleados (@Validated @RequestBody EntidadEmpleados empleado){

        if(!empleadosDAO.existsById(empleado.getId())){
            empleadosDAO.save(empleado);
            return true;
        }else{
            return false;
        }
    }

    public boolean borrarEmpleado(@PathVariable (value = "id") int id){
        if(empleadosDAO.existsById(id)){
            empleadosDAO.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarEmpleado(int id, EntidadEmpleados nuevoEmpleado) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if(empleado.isPresent()) {
            empleado.get().setNombre(nuevoEmpleado.getNombre());
            empleado.get().setPuesto(nuevoEmpleado.getPuesto());
            empleado.get().setDepno(nuevoEmpleado.getDepno());
            empleadosDAO.save(empleado.get());
            return true;
        } else {
            return false;
        }
    }
}