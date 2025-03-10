package juanarboleda.ultimorepaso.servicio;

import juanarboleda.ultimorepaso.modelo.dao.IEquipoDAO;
import juanarboleda.ultimorepaso.modelo.dao.IJugadorDAO;
import juanarboleda.ultimorepaso.modelo.entidades.EntidadEquipos;
import juanarboleda.ultimorepaso.modelo.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServicioJugador {

    @Autowired
    IJugadorDAO jugadorDAO;

    @Autowired
    IEquipoDAO equipoDAO;

    public Set<EntidadJugadores> buscarJugadorByNombreEquipo(String nombreEquipo) {

        EntidadEquipos equipo =equipoDAO.findByNombre(nombreEquipo);
        return equipo.getJugadores();
    }

    public EntidadJugadores crearJugadorValidado(EntidadJugadores jugador) {

        return jugadorDAO.save(jugador);
    }

    public List<EntidadJugadores> buscarJugadores(){

        return (List<EntidadJugadores>) jugadorDAO.findAll();
    }

}
