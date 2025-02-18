package juanarboleda.springthymeleafclase.servicio;

import juanarboleda.springthymeleafclase.modelo.dao.IDepartamentosDAO;
import juanarboleda.springthymeleafclase.modelo.entidades.EntidadDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDepartamentos {

    @Autowired
    IDepartamentosDAO departamentosDAO;

    public List<EntidadDepartamentos> mostrarDepartamentos() {

        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    public boolean guardarDepartamento(EntidadDepartamentos departamento) {

        if(!departamentosDAO.existsById(departamento.getId())) {

            departamentosDAO.save(departamento);
            return true;
        }else{
            return false;
        }
    }


}
