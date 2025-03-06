package juanarboleda.apiexamen.servcios;

import juanarboleda.apiexamen.modelo.daos.IPartidosDAO;
import juanarboleda.apiexamen.modelo.dtos.PartidosDTO;
import juanarboleda.apiexamen.modelo.entidades.EntidadEquipos;
import juanarboleda.apiexamen.modelo.entidades.EntidadPartidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPartidoDTO {

    public ResponseEntity<String> registrarPartido(PartidosDTO partidosDTO) {

        EntidadPartidos partido = new EntidadPartidos();
        EntidadEquipos equipoLocal = new EntidadEquipos();

        equipoLocal.setNombre(partidosDTO.getNombreEquipoLocal());
        equipoLocal.setEscudo(partidosDTO.getEscudoEquipoLocal());

        partido.setId(10);
        partido.setEquipoLocal(equipoLocal);
        partido.setGolesLocal(partidosDTO.getGolesEquipoLocal());
        partido.setGolesVisitante(partidosDTO.getGolesEquipoVisitante());
        partido.setHora(partidosDTO.getHora());
        partido.setFecha(partidosDTO.getFecha());

        return ResponseEntity.ok().body("Se registrado con exito este partido");
    }


}
