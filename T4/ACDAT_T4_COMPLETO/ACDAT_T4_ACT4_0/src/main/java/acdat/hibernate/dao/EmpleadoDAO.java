package acdat.hibernate.dao;

import acdat.hibernate.domain.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmpleadoDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public EmpleadoDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listarEmpleados() {
        String hql = "SELECT e FROM Empleado e";
        Query query = session.createQuery(hql);
        List<Empleado> lista = query.getResultList();

        for (Empleado empleado : lista) {
            System.out.println(empleado);
        }
    }
}
