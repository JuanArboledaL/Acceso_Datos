package com.iesbelen.dam.juanArboleda.view;

import com.iesbelen.dam.juanArboleda.model.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class appDietas {

    public static void main(String[] args) throws SQLException {

        var salir = false;
        var consola = new Scanner(System.in);

        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutar( opcion,consola);
            }catch (Exception e){
                System.out.println("Error al ejecutar opciones"+e.getMessage());
            }
            System.out.println();
        }

    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                *** Menú ***
                1. Conecctarse a la base de datos
                2. Crear la estructura de Centros Dietéticos
                3. Realizar la carga inicial de datos.
                4. Listar Centros
                5. Buscar Centro
                6. Modificar Centro
                7. Eliminar Centro
                8. Consulta 1
                9.  Consulta 2
                10. Consulta 3
                11. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    public static Boolean ejecutar(int opcion, Scanner consola) throws SQLException {

        var salir = false;
        Conexion con = new Conexion();
        switch (opcion) {
            case 1->{
                con.getConnection();
            }
            case 2->{
                con.crearTablas();
            }
            case 3 -> {
                con.cargarDatos();
            }
            case 4 ->{

            }
            case 5 -> {

            }
            case 6 -> {

            }
            case 7 -> {

            }
            case 8 -> {


            }
            case 9->{


            }
            case 10-> {

            }
            case 11->{
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: "+opcion);
        }
        return salir;
    }
}
