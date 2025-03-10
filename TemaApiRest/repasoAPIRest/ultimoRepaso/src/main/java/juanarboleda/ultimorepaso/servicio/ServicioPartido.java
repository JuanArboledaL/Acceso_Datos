package juanarboleda.ultimorepaso.servicio;

import juanarboleda.ultimorepaso.modelo.dao.IEquipoDAO;
import juanarboleda.ultimorepaso.modelo.dao.IPartidoDAO;
import juanarboleda.ultimorepaso.modelo.entidades.EntidadEquipos;
import juanarboleda.ultimorepaso.modelo.entidades.EntidadPartidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class ServicioPartido {

    @Autowired
    IPartidoDAO partidoDAO;

    @Autowired
    IEquipoDAO equipoDAO;

    public Set<EntidadPartidos> buscarPartidosByEquipo(String nombre) {

        EntidadEquipos equipo = equipoDAO.findByNombre(nombre);

        return equipo.getEquipoLocal();
    }

    public List<EntidadPartidos> mostrarPartidosGanadosByEquipoLocal(){

        return (List<EntidadPartidos>) partidoDAO.mostrarPartidosGanadosByEquipoLocal();
    }


}
