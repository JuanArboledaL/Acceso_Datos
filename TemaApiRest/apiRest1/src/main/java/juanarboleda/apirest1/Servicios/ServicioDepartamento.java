package juanarboleda.apirest1.Servicios;

import juanarboleda.apirest1.modelo.dao.IDepartamentosDAO;
import juanarboleda.apirest1.modelo.dao.IEmpleadosDAO;
import juanarboleda.apirest1.modelo.entidades.EntidadDepartamentos;
import juanarboleda.apirest1.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioDepartamento {

    @Autowired
    private IDepartamentosDAO departamentosDAO;

    public List<EntidadDepartamentos> buscarDepartamentos(){

        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    public Optional<EntidadDepartamentos> buscarDepartamentosPorCodigo(int id){
        return departamentosDAO.findById(id);
    }

}
