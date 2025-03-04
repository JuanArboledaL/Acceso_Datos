package juanarboleda.apiexamen.servcios;

import juanarboleda.apiexamen.modelo.daos.IEquiposDAO;
import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEntidadEquipos {

    @Autowired
    IEquiposDAO equiposDAO;

    public List<EntidadEquipos> buscarEquipos() {

        return (List<EntidadEquipos>) equiposDAO.findAll();
    }

    public Optional<EntidadEquipos> buscarEquipoById(int id) {

        return equiposDAO.findById(id);

    }

    public EntidadEquipos guardarEquipo(@Validated @RequestBody EntidadEquipos equipo) {

//        if (!equiposDAO.existsById(equipo.getId())) {
//
//            equiposDAO.save(equipo);
//            return true;
//
//        }else{
//
//            return false;
//        }

        return equiposDAO.save(equipo);

    }


}
