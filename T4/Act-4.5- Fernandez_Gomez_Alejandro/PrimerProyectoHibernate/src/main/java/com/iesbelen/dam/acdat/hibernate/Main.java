package com.iesbelen.dam.acdat.hibernate;

import com.iesbelen.dam.acdat.hibernate.dao.DepartamentoDAO;
import com.iesbelen.dam.acdat.hibernate.dao.EmpleadoDAO;
import com.iesbelen.dam.acdat.hibernate.domain.Departamento;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static int menu() {
        int opcion;

        System.out.println("""
                \n
                *** Departamentos ***
                1. Listar departamentos.
                2. Actualizar departamentos.
                3. Insertar departamento.
                4. Eliminar departamento.
                
                *** Empleados ***
                5. Listar empleados.
                6. Actualizar empleados.
                7. Insertar empleado.
                8. Eliminar empleado.

                *** Otros ***
                0. Salir.
                """);

        System.out.print("Indique una opción: ");
        opcion = sc.nextInt();

        return opcion;
    }

    public static void runMenu() {
        int opcion;

        do {
            opcion = menu();

            DepartamentoDAO departamentoDAO = new DepartamentoDAO();
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            sc.nextLine();

            switch (opcion) {

                case 1 -> departamentoDAO.listar();

                case 2 -> {
                    int depno;

                    System.out.print("Indique el departamento: ");
                    depno = sc.nextInt();

                    departamentoDAO.actualizar(depno);
                }

                case 3 -> departamentoDAO.insertar();

                case 4 -> {
                    int depno;
                    String seguro;

                    System.out.print("Indique el departamento: ");
                    depno = sc.nextInt();

                    departamentoDAO.buscarDepartamento(depno);

                    System.out.print("¿Está seguro de eliminar este departamento? (S/N)  ");
                    seguro = sc.next();

                    if(seguro.equalsIgnoreCase("S")) {
                        departamentoDAO.eliminar(depno);
                    }
                }

                case 5 -> empleadoDAO.listar();

                case 6 -> {
                    int empno;
                    System.out.print("Indique el empleado: ");
                    empno = sc.nextInt();

                    empleadoDAO.actualizar(empno);
                }

                case 7 -> empleadoDAO.insertar();

                case 8 -> {
                    int empno;
                    String seguro;

                    System.out.print("Indique el empleado: ");
                    empno = sc.nextInt();

                    System.out.print("¿Está seguro de eliminar este empleado? (S/N)  ");
                    seguro = sc.next();

                    if(seguro.equalsIgnoreCase("S")) {
                        empleadoDAO.eliminar(empno);
                    }
                }

                case 0 -> System.out.println("Hasta luego");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        runMenu();
    }
}