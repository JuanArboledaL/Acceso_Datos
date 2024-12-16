package org.example.conexio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexiones {

    public static Connection getConexion() throws SQLException {

        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/zona_fit_db", "postgres", "iesbelen");
        } catch (Exception e) {
            System.out.println("Error al conectarnos a la BD");
            System.out.println("Mensaje: " + e.getMessage());
            return null;
        }
    }

    private static void cargarDatosCuotas() throws SQLException {
        Connection con = null;
        try {
            con = getConexion();
            con.setAutoCommit(false);

            Statement s = con.createStatement();

            String sql = "INSERT INTO Cuotas (modalidad, cuota, situacion) " +
                    "VALUES ('mensual', 30.00, 'activo'), " +
                    "('trimestral', 85.00, 'activo'), " +
                    "('anual', 300.00, 'activo'), " +
                    "('mensual', 25.00, 'inactivo');";

            s.executeUpdate(sql);

            con.commit();
        } catch (Exception e) {
            con.rollback();
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    private static void cargarDatosClientes() throws SQLException {
        Connection con = null;
        try {
            con = getConexion();

            con.setAutoCommit(false);

            Statement s = con.createStatement();

            String sql = "INSERT INTO Clientes (nombre, apellido, email, telefono, estado, idCuota) " +
                    "VALUES ('Juan', 'Pérez', 'juan.perez@example.com', '123456789', 'activo', 1), " +
                    "('María', 'González', 'maria.gonzalez@example.com', '987654321', 'activo', 2), " +
                    "('Carlos', 'Ramírez', 'carlos.ramirez@example.com', '456789123', 'activo', 3), " +
                    "('Ana', 'López', 'ana.lopez@example.com', '789123456', 'inactivo', NULL), " +
                    "('Laura', 'Fernández', 'laura.fernandez@example.com', '321654987', 'activo', 1);";

            s.executeUpdate(sql);

            con.commit();
        } catch (Exception e) {
            con.rollback();
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    private static void crearTablaCuota() {
        String sql = "CREATE TABLE Cuotas (idCuota SERIAL PRIMARY KEY, modalidad VARCHAR(20) NOT NULL, cuota DECIMAL(10, 2) NOT NULL, situacion VARCHAR(10) CHECK (situacion IN ('activo', 'inactivo')) NOT NULL)";
        try (Statement s = Conexiones.getConexion().createStatement()) {

            s.executeUpdate(sql);

            System.out.println("Tabla Cuotas creada con éxito");

        } catch (SQLException e) {

            System.err.println("No se pudo crear la tabla Cuotas");
            System.err.println("Error: " + e.getMessage());

        }
    }
}
