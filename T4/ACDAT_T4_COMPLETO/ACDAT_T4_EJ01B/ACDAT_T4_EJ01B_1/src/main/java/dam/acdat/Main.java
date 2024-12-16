package dam.acdat;

import dam.acdat.hibernate.dao.UserDAO;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();

        userDAO.listar();

    }
}