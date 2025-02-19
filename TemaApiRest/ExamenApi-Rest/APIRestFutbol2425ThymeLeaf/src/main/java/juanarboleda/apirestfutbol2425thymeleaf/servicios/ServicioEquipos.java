package juanarboleda.apirestfutbol2425thymeleaf.servicios;

import juanarboleda.apirestfutbol2425.modelos.daos.IEquiposDAO;
import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEquipos {

    @Autowired
    IEquiposDAO equiposDAO;

    public List<EntidadEquipos> buscarEquipos() {

        return (List<EntidadEquipos>) equiposDAO.findAll();
    }

    public Optional<EntidadEquipos> buscarEquipoPorId(@PathVariable(value = "id") int id) {

        return equiposDAO.findById(id);
    }

    public boolean crearEquipo(@Validated @RequestBody EntidadEquipos Nvequipo) {

        Optional<EntidadEquipos> equipo = equiposDAO.findById(Nvequipo.getId());

        if(!equipo.isPresent()){

            equiposDAO.save(Nvequipo);
            return true;

        }else{

            return false;
        }
    }

    public boolean eliminarEquipo(@PathVariable(value = "id") int id) {

        Optional<EntidadEquipos> equipo = equiposDAO.findById(id);

        if(equipo.isPresent()) {

            equiposDAO.deleteById(id);
            return true;
        }else{

            return false;
        }

    }

    public boolean modificarEquipo(@RequestBody EntidadEquipos equi, @PathVariable(value = "id") int id) {

        Optional<EntidadEquipos> equipo = equiposDAO.findById(id);

        if(equipo.isPresent()) {

            equipo.get().setId(id);
            equipo.get().setNombre(equi.getNombre());
            equipo.get().setEscudo(equi.getEscudo());
            equiposDAO.save(equipo.get());

            return true;
        }else{

            return false;
        }
    }

}
