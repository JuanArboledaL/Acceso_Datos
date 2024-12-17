package com.iesbelen.dam.juanArboleda.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    public static Connection getConnection() {

        Connection conexion = null;
        String baseDatos = "appDieta";
        String urlBase = "jdbc:postgresql://localhost:5432/appDieta";
        String user = "postgres";
        String password = "iesbelen";

        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(urlBase, user, password);
            System.out.println("Se ha establecido la coneccion con exito");
        }
        catch (Exception e) {
            System.out.println("Error al conectarnos a la BD: " + e.getMessage());
        }
        return conexion;
    }


    public static void crearTablas() throws SQLException {

            String sqlTablaAutor = "CREATE TABLE CentrosDieteticos" +
                    "(" +
                    "   id serial PRIMARY KEY, " +
                    "   nombre VARCHAR(100) NOT NULL, " +
                    "   direccion VARCHAR(255) NOT NULL," +
                    "   telefono VARCHAR(20),"+
                    "   email VARCHAR(100),"+
                    "   horario TEXT" +
                    ");";


            String sqlTablaLibro = "CREATE TABLE Clientes " +
                    "(" +
                    "   id SERIAL PRIMARY KEY, " +
                    "   nombre VARCHAR(100) NOT NULL, " +
                    "   fecha_nacimiento DATE, " +
                    "   telefono VARCHAR(20), " +
                    "   email VARCHAR(100), " +
                    "   centro_dietetico_id INTEGER REFERENCES CentrosDieteticos(id) " +
                    ");";

            Connection con = null;

            try {
                con = getConnection();
                con.setAutoCommit(false);

                Statement stmt = con.createStatement();
                stmt.executeUpdate(sqlTablaAutor);
                stmt.executeUpdate(sqlTablaLibro);

                con.commit();
                stmt.close();
                System.out.println("Las tablas de la base de datos se han creado correctamente");

            } catch (Exception e) {
                con.rollback();
                System.out.println("Error al crear las tablas");
                System.out.println("Mensaje de error: " + e.getMessage());

            }
    }

    public static void cargarDatos() throws SQLException{

            String sqlCargarDatosCentros = "INSERT INTO CentrosDieteticos(nombre, direccion, telefono, email, horario)"+
                    "VALUES ('Nutrición Integral', 'Av. Siempreviva, 123', '555-1234567', 'nutricion@integral.com', 'Lun-Vie: 9am-2pm y 4pm8pm'),\n" +
                    " ('Bienestar y Salud', 'Calle del Sol, 78', '555-8765432', 'bienestar@salud.com', 'Mar-Jue: 10am-1pm y 3pm7pm')";

            String sqlCargarDatosClientes = "INSERT INTO Clientes (nombre, fecha_nacimiento, telefono, email, centro_dietetico_id)"+
                    "VALUES ('Juan Pérez', '1980-01-15', '555-1111111', 'juanperez@example.com', 1),\n" +
                    " ('María López', '1992-04-20', '555-2222222', 'marialopez@example.com', 2),\n" +
                    " ('Carlos García', '1975-11-05', '555-3333333', 'carlosgarcia@example.com', 1),\n" +
                    " ('Ana Rodríguez', '1998-07-12', '555-4444444', 'anarodriguez@example.com', 2),\n" +
                    " ('Sofía Martínez', '1995-11-28', '555-5555555', 'sofiamartinez@example.com', 2),\n" +
                    " ('David Hernández', '1982-03-10', '555-6666666', 'davidhernandez@example.com', 1),\n" +
                    " ('Laura Jiménez', '1999-09-25', '555-7777777', 'laurajimenez@example.com', 2),\n" +
                    " ('Pablo Álvarez', '1988-05-18', '555-8888888', 'pabloalvarez@example.com', 1),\n" +
                    " ('Andrea Ruiz', '1991-12-03', '555-9999999', 'andrearuiz@example.com', 2)," +
                    "('Víctor Gómez', '1985-08-22', '555-1234567', 'victorgomez@example.com', 1),\n" +
                    " ('Sara Fernández', '1997-04-15', '555-2345678', 'sarafernandez@example.com', 2),\n" +
                    " ('Miguel Santos', '1983-10-30', '555-3456789', 'miguelsantos@example.com', 1),\n" +
                    " ('Lucía Díaz', '1994-06-17', '555-4567890', 'luciadaz@example.com', 2),\n" +
                    " ('Marcos López', '1987-02-04', '555-5678901', 'marcoslopez@example.com', 1),\n" +
                    " ('Irene García', '1993-08-29', '555-6789012', 'ireneg@example.com', 2);";

            Connection con = null;

            try {
                con = getConexion();
                con.setAutoCommit(false);

                Statement stmt = con.createStatement();
                stmt.executeUpdate(sqlCargarDatosCentros);
                stmt.executeUpdate(sqlCargarDatosClientes);

                con.commit();
                stmt.close();
                System.out.println("Se han insertado datos en las tablas correctamente.");

            } catch (Exception e) {
                con.rollback();
                System.out.println("Error al insertar datos");
                System.out.println("Mensaje de error: " + e.getMessage());

            }

        }

    public static Connection getConexion() {
        Connection con = null;
        return con;
    }

}
