package com.iesbelen.dam.juanArboleda.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfazDao {
    List<Object> listarCentros() throws SQLException;
    boolean agregarCentro(Object object) throws SQLException;
    Object buscarCentro(Object object) throws SQLException;
    boolean modificarCentro(Object object) throws SQLException;
    boolean eliminarCentro(Object object) throws SQLException;


}
