package com.iesbelen.dam.acdat.hibernate.dao;

import com.iesbelen.dam.acdat.hibernate.domain.Departamento;
import com.iesbelen.dam.acdat.hibernate.domain.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class EmpleadoDAO  implements InterfazDAO{
    static Scanner sc = new Scanner(System.in);
    private SessionFactory sessionFactory;
    private Session session;

    public EmpleadoDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listar() {
        String hql = "SELECT e FROM Empleado e";
        Query query = session.createQuery(hql);
        List<Empleado> listEmpleados = query.getResultList();

        for (Empleado e : listEmpleados) {
            System.out.println("Empleado: " + e.toString());
        }
    }

    @Override
    public void actualizar(int empno) {
        Query<Empleado> miQuery = session.createQuery("from Empleado where id = :empno");
        List<Empleado> listaEmpleados = miQuery.setParameter("empno", empno).list();

        Transaction transaction = session.beginTransaction();

        Empleado empleado = (Empleado) listaEmpleados.getFirst();
        empleado.setId(empno);

        session.update(empleado);
        transaction.commit();

        System.out.println("!! Actualizado ¡¡");
    }

    @Override
    public void insertar() {
        String nombre;
        String puesto;
        int depno;

        System.out.print("Ingrese el nombre del empleado: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese el puesto del empleado: ");
        puesto = sc.nextLine();

        System.out.print("Ingrese el departamento del empleado: ");
        depno = sc.nextInt();

        Departamento departamento;
        departamento = session.load(Departamento.class, depno);

        Transaction transaction = session.beginTransaction();
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setPuesto(puesto);
        empleado.setDepno(departamento);
        session.save(empleado);
        transaction.commit();

        System.out.println("Empleado añadido");
    }

    @Override
    public void eliminar(int empno) {
        Query<Empleado> miQuery = session.createQuery("from Empleado where id = :empno");
        miQuery.setParameter("empno", empno);
        Empleado empleado = (Empleado) miQuery.uniqueResult();

        Transaction transaction = session.beginTransaction();
        session.delete(empleado);
        transaction.commit();
        System.out.println("Se ha eliminado el empleado con id: " + empno);
    }
}