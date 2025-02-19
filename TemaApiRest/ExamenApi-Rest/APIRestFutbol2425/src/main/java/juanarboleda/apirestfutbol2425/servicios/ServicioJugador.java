package juanarboleda.apirestfutbol2425.servicios;

import juanarboleda.apirestfutbol2425.modelos.daos.IJugadoresDAO;
import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import juanarboleda.apirestfutbol2425.modelos.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class ServicioJugador {

//    @Autowired
//    IJugadoresDAO jugadoresDAO;
//

//    public List<EntidadJugadores> buscarJugadorByNombreEquipo (String nombreEquipo) {
//
//        return (List<EntidadJugadores>) jugadoresDAO.buscarJugadorByNombreEquipo(nombreEquipo);
//
//    }

//    public boolean CrearJugadorValidado(@Validated @RequestBody EntidadJugadores nvJugador){
//
//        Optional<EntidadJugadores> jugador = jugadoresDAO.findById(nvJugador.getId());
//        if(!jugador.isPresent()){
//
//            if(nvJugador.getNombre().length() > 5 && nvJugador.getNombre().length() < 25 && nvJugador.getDorsal() > 1 && nvJugador.getDorsal() <= 30){
//
//                jugadoresDAO.save(nvJugador);
//                return true;
//            }else{
//
//                return false;
//            }
//        }else{
//            return false;
//        }
//
//    }

}
