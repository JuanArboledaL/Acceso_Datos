package com.iesbelen.dam.juanArboleda.dao;

import com.iesbelen.dam.juanArboleda.model.Conexion;
import com.iesbelen.dam.juanArboleda.model.CentrosDieteticos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CentrosDieteteicosDao implements InterfazDao {
    
    @Override
    public List<Object> listarCentros() throws SQLException {
        List<Object> CentrosDieteticoses = new ArrayList<>();
        String sql = "SELECT * FROM CentrosDieteticos";
        Connection con = null;

        try {
            Conexion Conexion = null;
            con = Conexion.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                CentrosDieteticos centro = new CentrosDieteticos();
                CentrosDieteticos.setNombre(rs.getString("nombre"));
                CentrosDieteticoses.add(centro);
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Ha habido un error listando los CentroDieteticoses");
            System.out.println("Mensaje del error: " + e.getMessage());

        }

        return CentrosDieteticoses;
    }

    @Override
    public boolean agregarCentro(Object object) throws SQLException {
        CentrosDieteticos centro = (CentrosDieteticos) object;
        String sql = "INSERT INTO CentroDieteticos (nombre) VALUES (?)";
        Connection con = null;

        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, centro.getNombre());
            ps.executeUpdate();

            con.commit();
            ps.close();
            return true;

        } catch (Exception e) {
            con.rollback();
            System.out.println("Ha ocurrido un error insertando el CentroDieteticos.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return false;

        }
    }

    @Override
    public Object buscarCentro(Object object) throws SQLException {

        CentrosDieteticos centro = (CentrosDieteticos) object;
        CentrosDieteticos centros = new CentrosDieteticos();
        String sql = "SELECT * FROM CentroDieteticos WHERE nombre = ?";
        Connection con = null;

        try {

            con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                centros.setNombre(rs.getString("nombre"));
            }

            rs.close();
            ps.close();

            return centro;

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error buscando el CentroDieteticos.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return null;

        }
    }

    @Override
    public boolean modificarCentro(Object object) throws SQLException {
        CentrosDieteticos centro = (CentrosDieteticos) object;
        String sql = "UPDATE CentroDieteticos SET nombre = ?";
        Connection con = null;

        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, centro.getNombre());
            ps.executeUpdate();

            con.commit();
            ps.close();
            return true;

        } catch (Exception e) {
            con.rollback();
            System.out.println("Ha ocurrido un error actualizando el CentroDieteticos.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return false;

        }
    }

    @Override
    public boolean eliminarCentro(Object object) throws SQLException {
        CentrosDieteticos cecntro = (CentrosDieteticos) object;
        String sql = "DELETE FROM CentroDieteticos WHERE nombre = ?";
        Connection con = null;

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error eliminando el CentroDieteticos.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return false;

        }
    }
}

