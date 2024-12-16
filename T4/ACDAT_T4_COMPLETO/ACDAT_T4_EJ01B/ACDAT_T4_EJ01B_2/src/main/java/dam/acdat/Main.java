package dam.acdat;

import dam.acdat.hibernate.dao.ConcesionarioDAO;
import dam.acdat.hibernate.dao.VehiculoDAO;
import dam.acdat.hibernate.domain.Concesionario;
import dam.acdat.hibernate.domain.Vehiculo;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ConcesionarioDAO concesionarioDAO = new ConcesionarioDAO();
        VehiculoDAO vehiculoDAO = new VehiculoDAO();

        Concesionario concesionario1 = new Concesionario( "concesionario1", "concesionario1", "Calle", 2, "concesionario1@gmail.com");

        Vehiculo vehiculo1 = new Vehiculo("Coche1", "modelo1", "Rojo", "1", new Date(), 1, concesionario1);
        Vehiculo vehiculo2 = new Vehiculo("Coche2", "modelo2", "Verde", "2", new Date(), 2, concesionario1);
        Vehiculo vehiculo3 = new Vehiculo("Coche3", "modelo3", "Blanco", "3", new Date(), 3, concesionario1);

        ArrayList vehiculos = new ArrayList();
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);

        concesionario1.setVehiculos(vehiculos);

        concesionarioDAO.guardarConcesionario(concesionario1);

        vehiculoDAO.guardarVehiculo(vehiculo1);
        vehiculoDAO.guardarVehiculo(vehiculo2);
        vehiculoDAO.guardarVehiculo(vehiculo3);

        System.out.println("Listado de concesionarios:");
        concesionarioDAO.listarConcesionarios();

        System.out.println("\nListado de vehículos:");
        vehiculoDAO.listarVehiculos();

    }
}