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

    public void crearEmpleado(Empleado empleado) {
        session.beginTransaction();
        session.persist(empleado);
        session.getTransaction().commit();
    }

    public Empleado buscarEmpleadoPorId(int id) {

        String hql = "from Empleado where id = :id";
        Query<Empleado> query = session.createQuery(hql, Empleado.class);
        query.setParameter("id", id);
        return query.uniqueResult();

    }

    public void listarEmpleados() {
        String hql = "SELECT e FROM Empleado e";
        Query<Empleado> query = session.createQuery(hql, Empleado.class);
        List<Empleado> lista = query.getResultList();

        for (Empleado empleado : lista) {
            System.out.println(empleado);
        }
    }

    public void actualizarEmpleadoPorId(Empleado empleado) {
        session.beginTransaction();
        session.merge(empleado);
        session.getTransaction().commit();
    }

    public void eliminarEmpleado(Empleado empleado) {
        session.beginTransaction();
        session.remove(empleado);
        session.getTransaction().commit();
    }
}
