package juanarboleda.appbiblioteca2425.servicios;

import juanarboleda.appbiblioteca2425.modelo.dao.IAutoresDAO;
import juanarboleda.appbiblioteca2425.modelo.dao.IUsuariosDAO;
import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadAutores;
import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuarios {

    @Autowired
    IUsuariosDAO usuariosDAO;

    public List<EntidadUsuarios> buscarUsuarios(){

        return (List<EntidadUsuarios>) usuariosDAO.findAll();
    }

    public Optional<EntidadUsuarios> buscarUsuariosPorId(int id){
        return  usuariosDAO.findById(id);
    }
}
