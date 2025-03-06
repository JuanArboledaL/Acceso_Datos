package juanarboleda.examenprestamos2025.servicios;

import juanarboleda.examenprestamos2025.modelo.dao.IUsuarioDAO;
import juanarboleda.examenprestamos2025.modelo.entidades.EntidadUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuarios {

    @Autowired
    IUsuarioDAO usuarioDAO;

    public List<EntidadUsuarios> buscarUsuarios(){

        return (List<EntidadUsuarios>)usuarioDAO.findAll();
    }

    public Optional<EntidadUsuarios> buscarUsuariosId(int id){

        return usuarioDAO.findById(id);
    }
}
