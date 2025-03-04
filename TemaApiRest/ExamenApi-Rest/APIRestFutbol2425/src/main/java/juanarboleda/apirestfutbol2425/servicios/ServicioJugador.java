package juanarboleda.apirestfutbol2425.servicios;

import org.springframework.stereotype.Service;


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
