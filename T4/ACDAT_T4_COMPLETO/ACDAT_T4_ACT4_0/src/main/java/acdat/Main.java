package acdat;

import acdat.hibernate.dao.DepartamentoDAO;
import acdat.hibernate.dao.EmpleadoDAO;

public class Main {
    public static void main(String[] args) {

        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        empleadoDAO.listarEmpleados();

        departamentoDAO.listarDepartamento();

    }
}