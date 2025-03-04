package juanarboleda.apiexamen.servcios;

import juanarboleda.apiexamen.modelo.daos.IEquiposDAO;
import juanarboleda.apiexamen.modelo.daos.IPartidosDAO;
import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import juanarboleda.apiexamen.modelo.entidades.EntidadPartidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServicioPartido {

    @Autowired
    IEquiposDAO equiposDAO;

    @Autowired
    IPartidosDAO partidosDAO;

    public Set<EntidadPartidos> mostrarPartidoByEquipo(String equipo) {

        EntidadEquipos equipos = equiposDAO.findByNombre(equipo);

        return equipos.getPartidoLocal();
    }

    public List<EntidadPartidos> buscarPartidosGanadosLocal() {

        return (List<EntidadPartidos>) partidosDAO.findPartidosGanadosPorEquipoLocal();
    }

}
