package juanarboleda.ultimorepaso.servicio;

import juanarboleda.ultimorepaso.modelo.dao.IEquipoDAO;
import juanarboleda.ultimorepaso.modelo.entidades.EntidadEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEquipo {

    @Autowired
    IEquipoDAO equipoDAO;

    public List<EntidadEquipos> buscarEquipos() {

        return (List<EntidadEquipos>) equipoDAO.findAll();
    }

    public Optional<EntidadEquipos> buscarEquipoById(int id) {

        return equipoDAO.findById(id);
    }

    public EntidadEquipos crearEquipo(EntidadEquipos equipo) {
        return equipoDAO.save(equipo);
    }

    public boolean eliminarEquipo(int id) {

        if (equipoDAO.existsById(id)) {
            equipoDAO.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean modificarEquipo(EntidadEquipos equipo, int id) {

        Optional<EntidadEquipos>equipoA = equipoDAO.findById(id);

        if (equipoA.isPresent()) {

            equipoA.get().setId(equipo.getId());
            equipoA.get().setNombre(equipo.getNombre());
            equipoA.get().setEscudo(equipo.getEscudo());
            equipoDAO.save(equipoA.get());
            return true;
        }else{
            return false;
        }
    }
}
