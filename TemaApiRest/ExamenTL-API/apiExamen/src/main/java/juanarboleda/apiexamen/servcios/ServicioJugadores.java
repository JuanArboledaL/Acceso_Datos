package juanarboleda.apiexamen.servcios;

import juanarboleda.apiexamen.modelo.daos.IEquiposDAO;
import juanarboleda.apiexamen.modelo.daos.IJugadores;
import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import juanarboleda.apiexamen.modelo.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServicioJugadores {

    @Autowired
    IJugadores jugadores;

    @Autowired
    IEquiposDAO equiposDAO;

    public Set<EntidadJugadores> buscarJugadorByNombreEquipo(String nombreEquipo) {

        EntidadEquipos equipo = equiposDAO.findByNombre(nombreEquipo);

        return equipo.getJugadores();
    }
}
