package com.iesbelen.dam.acdat.hibernate.dao;

import com.iesbelen.dam.acdat.hibernate.domain.Departamento;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class DepartamentoDAO  implements InterfazDAO {
    static Scanner sc = new Scanner(System.in);
    private SessionFactory sessionFactory;
    private Session session;

    public DepartamentoDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listar() {
        String hql = "SELECT d FROM Departamento d";
        Query query = session.createQuery(hql);
        List<Departamento> listDepartamentos = query.getResultList();

        for (Departamento d : listDepartamentos) {
            System.out.println("Departamento: " + d.toString());
        }
    }

    public void actualizar(int depno) {
        Query<Departamento> miQuery = session.createQuery("from Departamento where id = :depno");
        List<Departamento> listaDepartamentos = miQuery.setParameter("depno", depno).list();

        Transaction transaction = session.beginTransaction();

        Departamento departamento = (Departamento) listaDepartamentos.getFirst();
        departamento.setId(depno);

        session.update(departamento);
        transaction.commit();
    }

    public void insertar() {
        String nombre;
        String ubicacion;

        System.out.print("Ingrese el nombre del departamento: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese la ubicación del departamento: ");
        ubicacion = sc.nextLine();

        Transaction transaction = session.beginTransaction();
        Departamento departamento = new Departamento();
        departamento.setNombre(nombre);
        departamento.setUbicacion(ubicacion);
        session.save(departamento);
        transaction.commit();
    }

    public void eliminar(int depno) {
        Query<Departamento> miQuery = session.createQuery("from Departamento where id = :depno");
        miQuery.setParameter("depno", depno);
        Departamento departamento = (Departamento) miQuery.uniqueResult();

        Transaction transaction = session.beginTransaction();
        session.delete(departamento);
        transaction.commit();
        System.out.println("Se ha eliminado el departamento con id: " + depno);
    }

    public void buscarDepartamento(int depno) {
        Departamento departamento = (Departamento) session.get(Departamento.class, depno);
        System.out.println("Departamento: " + departamento.toString());
    }
}