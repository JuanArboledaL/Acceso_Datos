package juanarboleda.apirestfutbol2425thymeleaf.servicios;

import juanarboleda.apirestfutbol2425thymeleaf.modelo.daos.IJugadoresDAO;
import juanarboleda.apirestfutbol2425thymeleaf.modelo.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class ServicioJugador {

    @Autowired
    IJugadoresDAO jugadoresDAO;


    public List<EntidadJugadores> listarEntidadJugadores(){

        return (List<EntidadJugadores>) jugadoresDAO.findAll();
    }

    public Optional<EntidadJugadores> buscarJugador(@PathVariable(value = "id") int id){

        return (Optional<EntidadJugadores>) jugadoresDAO.findById(id);
    }

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
