package juanarboleda.act1.servicios;

import juanarboleda.act1.modelo.dao.IEmpleadosDAO;
import juanarboleda.act1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpleados {

    @Autowired
    private IEmpleadosDAO empleadosDAO;

    public List<EntidadEmpleados> buscarEmpleados(){
        return (List<EntidadEmpleados>) empleadosDAO.findAll();
    }

    public Optional<EntidadEmpleados> buscarEmpleadosPorId(int id){

        return empleadosDAO.findById(id);
    }

    public List<EntidadEmpleados> buscarEmpleadosPorPuesto(String nombre){

        return empleadosDAO.findByPuesto(nombre);
    }

}
