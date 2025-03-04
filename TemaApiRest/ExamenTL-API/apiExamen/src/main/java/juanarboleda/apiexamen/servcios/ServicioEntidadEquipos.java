package juanarboleda.apiexamen.servcios;

import juanarboleda.apiexamen.modelo.daos.IEquiposDAO;
import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    public EntidadEquipos guardarEquipo(EntidadEquipos equipo) {

        return equiposDAO.save(equipo);
    }

    public Boolean borrarEquipo(int id) {

        Optional<EntidadEquipos> equipo = equiposDAO.findById(id);

        if (equipo.isPresent()) {
            equiposDAO.delete(equipo.get());
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarEquipo(EntidadEquipos equipo, int id) {

        Optional<EntidadEquipos> equipoActual = equiposDAO.findById(id);
        if (equipoActual.isPresent()) {

            equipoActual.get().setId(equipo.getId());
            equipoActual.get().setNombre(equipo.getNombre());
            equipoActual.get().setEscudo(equipo.getEscudo());
            equiposDAO.save(equipoActual.get());
            return true;
        }else{

            return false;
        }
    }


}
