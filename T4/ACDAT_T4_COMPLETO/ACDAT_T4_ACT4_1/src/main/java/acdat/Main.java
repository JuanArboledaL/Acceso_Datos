package acdat;

import acdat.hibernate.dao.DepartamentoDAO;
import acdat.hibernate.dao.EmpleadoDAO;
import acdat.hibernate.domain.Departamento;
import acdat.hibernate.domain.Empleado;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean finalizado = false;
        int opcion;

        do {
            System.out.println("""
                    ***Menu***
                    1. Agregar Departamento
                    2. Buscar Departamento por id
                    3. Listar Departamentos
                    4. Modificar Departamento
                    5. Eliminar Departamento
                    6. Agregar Empleado
                    7. Buscar Empleado por id
                    8. Listar Empleado
                    9. Modificar Empleado
                    10. Eliminar Empleado
                    0. Salir
                    """);
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> {
                    agregarDepartamento();
                }
                case 2 -> {
                    buscarDepartamentoPorId();
                }
                case 3 -> {
                    listarDepartamentos();
                }
                case 4 -> {
                    modificarDepartamento();
                }
                case 5 -> {
                    eliminarDepartamento();
                }
                case 6 -> {
                    agregarEmpleado();
                }
                case 7 -> {
                    buscarEmpleadoPorId();
                }
                case 8 -> {
                    listarEmpleados();
                }
                case 9 -> {
                    modificarEmpleado();
                }
                case 10 -> {
                    eliminarEmpleado();
                }
                case 0 -> {
                    finalizado = true;
                }
            }
        } while (!finalizado);

    }

    private static void agregarDepartamento() {
        Scanner sc = new Scanner(System.in);
        DepartamentoDAO dao = new DepartamentoDAO();

        Departamento departamento = new Departamento();
        System.out.print("Introduce el nombre del departamento: ");
        departamento.setNombreDepartamento(sc.nextLine());
        System.out.print("Introduce la ubicación del departamento: ");
        departamento.setUbicacionDepartamento(sc.nextLine());
        departamento.setEmpleados(new LinkedHashSet<>());

        dao.crearDepartamento(departamento);
    }

    private static void buscarDepartamentoPorId() {
        Scanner sc = new Scanner(System.in);
        DepartamentoDAO dao = new DepartamentoDAO();
        System.out.print("Introduce el id del departamento: ");
        int id = sc.nextInt();
        sc.nextLine();

        Departamento departamento = dao.buscarDepartamentoPorId(id);
        if (departamento == null) {
            System.out.println("No existe el departamento con id: " + id);
        }
        else {
            System.out.println(departamento);
        }

    }

    private static void listarDepartamentos() {
        DepartamentoDAO dao = new DepartamentoDAO();
        System.out.print("Listado de departamentos: ");
        dao.listarDepartamento();
    }

    private static void modificarDepartamento() {
        Scanner sc = new Scanner(System.in);
        DepartamentoDAO dao = new DepartamentoDAO();
        System.out.print("Introduce el id del departamento a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Departamento actual = dao.buscarDepartamentoPorId(id);
        if(actual != null) {
            System.out.println("Estás seguro de querer cambiar el departamento\n" + actual);
            System.out.print("Introduce SI para modificar el departamento: ");
            if (sc.nextLine().equalsIgnoreCase("SI")) {
                System.out.print("Introduce el nombre del departamento: ");
                actual.setNombreDepartamento(sc.nextLine());
                System.out.print("Introduce la ubicación del departamento: ");
                actual.setUbicacionDepartamento(sc.nextLine());
                dao.actualizarDepartamentoPorId(actual);
                System.out.println("Departamento actualizado correctamente");
                System.out.println(actual);
            }
        } else {
            System.out.println("No existe el departamento con id: " + id);
        }
    }

    private static void eliminarDepartamento() {
        Scanner sc = new Scanner(System.in);
        DepartamentoDAO dao = new DepartamentoDAO();
        System.out.print("Introduce el id del departamento a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Departamento actual = dao.buscarDepartamentoPorId(id);
        if(actual != null) {
            System.out.println("Estás seguro de querer cambiar el departamento\n" + actual);
            System.out.print("Introduce SI para eliminar el departamento: ");
            if (sc.nextLine().equalsIgnoreCase("SI")) {
                dao.eliminarDepartamento(actual);
                System.out.println("Departamento eliminado correctamente");
            }
        } else {
            System.out.println("No existe el departamento con id: " + id);
        }
    }

    private static void agregarEmpleado() {
        Scanner sc = new Scanner(System.in);
        EmpleadoDAO dao = new EmpleadoDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        Empleado empleado = new Empleado();
        System.out.print("Introduce el nombre del empleado: ");
        empleado.setNombreEmpleado(sc.nextLine());
        System.out.print("Introduce el puesto del empleado: ");
        empleado.setPuestoEmpleado(sc.nextLine());
        System.out.print("Introduce el id del departamento en el que está: ");
        Departamento departamento = departamentoDAO.buscarDepartamentoPorId(sc.nextInt());
        sc.nextLine();

        while (departamento == null) {
            System.out.print("No existe ningún departamento con ese id\nIntroduce el id del departamento en el que está: ");
            departamento = departamentoDAO.buscarDepartamentoPorId(sc.nextInt());
            sc.nextLine();
        }
        empleado.setDepno(departamento);

        dao.crearEmpleado(empleado);
    }

    private static void buscarEmpleadoPorId() {
        Scanner sc = new Scanner(System.in);
        EmpleadoDAO dao = new EmpleadoDAO();

        System.out.print("Introduce el id del empleado: ");
        int id = sc.nextInt();
        sc.nextLine();

        Empleado empleado = dao.buscarEmpleadoPorId(id);
        if (empleado == null) {
            System.out.println("No existe el empleado con id: " + id);
        }
        else {
            System.out.println(empleado);
        }

    }

    private static void listarEmpleados() {
        EmpleadoDAO dao = new EmpleadoDAO();
        System.out.print("Listado de empleados: ");
        dao.listarEmpleados();
    }

    private static void modificarEmpleado() {
        Scanner sc = new Scanner(System.in);
        EmpleadoDAO dao = new EmpleadoDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        System.out.print("Introduce el id del empleado a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Empleado actual = dao.buscarEmpleadoPorId(id);
        if(actual != null) {
            System.out.println("Estás seguro de querer cambiar el empleado\n" + actual);
            System.out.print("Introduce SI para modificar el empleado: ");
            if (sc.nextLine().equalsIgnoreCase("SI")) {
                System.out.print("Introduce el nombre del empleado: ");
                actual.setNombreEmpleado(sc.nextLine());
                System.out.print("Introduce el puesto del empleado: ");
                actual.setPuestoEmpleado(sc.nextLine());
                System.out.print("Introduce el id del departamento en el que está: ");
                Departamento departamento = departamentoDAO.buscarDepartamentoPorId(sc.nextInt());
                sc.nextLine();

                while (departamento == null) {
                    System.out.print("No existe ningún departamento con ese id\nIntroduce el id del departamento en el que está: ");
                    departamento = departamentoDAO.buscarDepartamentoPorId(sc.nextInt());
                    sc.nextLine();

                }
                actual.setDepno(departamento);

                dao.actualizarEmpleadoPorId(actual);
            }
        } else {
            System.out.println("No existe el empleado con id: " + id);
        }
    }

    private static void eliminarEmpleado() {
        Scanner sc = new Scanner(System.in);
        EmpleadoDAO dao = new EmpleadoDAO();
        System.out.print("Introduce el id del empleado a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Empleado actual = dao.buscarEmpleadoPorId(id);
        if(actual != null) {
            System.out.println("Estás seguro de querer cambiar el empleado\n" + actual);
            System.out.print("Introduce SI para eliminar el empleado: ");
            if (sc.nextLine().equalsIgnoreCase("SI")) {
                dao.eliminarEmpleado(actual);
                System.out.println("Empleado eliminado correctamente");
            }
        } else {
            System.out.println("No existe el empleado con id: " + id);
        }
    }
}