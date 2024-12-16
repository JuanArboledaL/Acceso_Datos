package com.iesbelen.dam.acdat.hibernate.dao;

import com.iesbelen.dam.acdat.hibernate.domain.Direccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DireccionDAO {

    private SessionFactory sessionFactory;
    private Session session;

    public DireccionDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listar() {
        String hlc = "SELECT d from Direccion d";

        Query query = session.createQuery(hlc);
        List<Direccion> lista = query.getResultList();

        for (Direccion d : lista) {
            System.out.println(d);
        }
    }

}
