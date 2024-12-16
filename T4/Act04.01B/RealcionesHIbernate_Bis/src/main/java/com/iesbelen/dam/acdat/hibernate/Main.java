package com.iesbelen.dam.acdat.hibernate;

import com.iesbelen.dam.acdat.hibernate.dao.UserDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        dao.listar();
    }
}