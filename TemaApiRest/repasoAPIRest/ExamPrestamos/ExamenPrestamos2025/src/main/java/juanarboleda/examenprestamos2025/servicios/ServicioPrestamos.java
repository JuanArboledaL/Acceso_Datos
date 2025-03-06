package juanarboleda.examenprestamos2025.servicios;

import juanarboleda.examenprestamos2025.modelo.dao.IPrestamosDAO;
import juanarboleda.examenprestamos2025.modelo.entidades.EntidadPrestamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPrestamos {

    @Autowired
    IPrestamosDAO prestamosDAO;

    public List<EntidadPrestamos> buscarPrestamo(){

        return (List<EntidadPrestamos>)prestamosDAO.findAll();
    }

    public EntidadPrestamos guardarPrestamos(EntidadPrestamos prestamo){

        return prestamosDAO.save(prestamo);
    }
}
