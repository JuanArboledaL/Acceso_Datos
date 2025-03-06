package juanarboleda.examenprestamos2025.servicios;

import juanarboleda.examenprestamos2025.modelo.dao.IAutoresDAO;
import juanarboleda.examenprestamos2025.modelo.entidades.EntidadAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioAutores {

    @Autowired
    IAutoresDAO autoresDAO;

    public List<EntidadAutores> buscarAutores() {

        return (List<EntidadAutores>) autoresDAO.findAll();
    }

    public Optional<EntidadAutores> buscarAutorPorId(int id) {

        return autoresDAO.findById(id);
    }

    public EntidadAutores guardarAutor(EntidadAutores entidadAutores) {

        return autoresDAO.save(entidadAutores);
    }

    public boolean eliminarAutor(int id) {

        if (autoresDAO.existsById(id)) {

            autoresDAO.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarAutor(EntidadAutores entidadAutores) {

        Optional<EntidadAutores> autorNuevo = buscarAutorPorId(entidadAutores.getId());

        if (autorNuevo.isPresent()) {

            autorNuevo.get().setNombreAutor(entidadAutores.getNombreAutor());
            autorNuevo.get().setId(entidadAutores.getId());
            autorNuevo.get().setPais(entidadAutores.getPais());
            autorNuevo.get().setLibros(entidadAutores.getLibros());
            autoresDAO.save(autorNuevo.get());
            return true;
        }else{

            return false;
        }
    }
}
