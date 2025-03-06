package juanarboleda.apiexamen.controladores;

import juanarboleda.apiexamen.modelo.dtos.PartidosDTO;
import juanarboleda.apiexamen.servcios.ServicioPartidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partido/dto")
public class ControladorPartidoDto {

    @Autowired
    ServicioPartidoDTO servicioPartidoDTO;

    @PostMapping
    public ResponseEntity<String> crearPartido(@RequestBody PartidosDTO partidosDTO) {

        return servicioPartidoDTO.registrarPartido(partidosDTO);
    }


}
