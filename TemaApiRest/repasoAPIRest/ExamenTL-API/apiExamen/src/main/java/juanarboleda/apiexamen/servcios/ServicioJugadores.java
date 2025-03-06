package juanarboleda.apiexamen.servcios;

import juanarboleda.apiexamen.modelo.daos.IEquiposDAO;
import juanarboleda.apiexamen.modelo.daos.IJugadoresDAO;
import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import juanarboleda.apiexamen.modelo.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServicioJugadores {

    @Autowired
    IJugadoresDAO jugadoresDAO;

    @Autowired
    IEquiposDAO equiposDAO;

    public Set<EntidadJugadores> buscarJugadorByNombreEquipo(String nombreEquipo) {

        EntidadEquipos equipo = equiposDAO.findByNombre(nombreEquipo);

        return equipo.getJugadores();
    }

    public EntidadJugadores CrearJugadorValidado(EntidadJugadores jugador) {

        return jugadoresDAO.save(jugador);
    }

    public List<EntidadJugadores> listarJugadores() {

        return (List<EntidadJugadores>) jugadoresDAO.findAll();
    }
}
