package juanarboleda.apirest1.Servicios;

import juanarboleda.apirest1.modelo.dao.IEmpleadosDAO;
import juanarboleda.apirest1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpleados {

    @Autowired
    private IEmpleadosDAO empleadosDAO;

    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados(){

        return (List<EntidadEmpleados>) empleadosDAO.findAll();
    }

    public Optional<EntidadEmpleados> buscarEmpleadosPorCodigo(int id){
        return empleadosDAO.findById(id);
    }

    @GetMapping
    public List<EntidadEmpleados> buscarEmpleadosPorPuesto(String puesto){

        return empleadosDAO.findByPuestoContaining(puesto);
    }
}
