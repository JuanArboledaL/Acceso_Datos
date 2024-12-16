package acdat.hibernate.dao;

import acdat.hibernate.domain.Departamento;
import acdat.hibernate.domain.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DepartamentoDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public DepartamentoDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void crearDepartamento(Departamento departamento) {
        session.beginTransaction();
        session.persist(departamento);
        session.getTransaction().commit();
    }

    public Departamento buscarDepartamentoPorId(int id) {

        String hql = "from Departamento where id = :id";
        Query<Departamento> query = session.createQuery(hql, Departamento.class);
        query.setParameter("id", id);
        return query.uniqueResult();

    }

    public void listarDepartamento() {
        String hql = "SELECT d FROM Departamento d";
        Query<Departamento> query = session.createQuery(hql, Departamento.class);
        List<Departamento> listDirecciones = query.getResultList();

        for (Departamento d : listDirecciones) {
            System.out.println("Direccion: " + d.toString());
        }
    }

    public void actualizarDepartamentoPorId(Departamento departamento) {

        session.beginTransaction();
        session.merge(departamento);
        session.getTransaction().commit();
    }

    public void eliminarDepartamento(Departamento departamento) {
        session.beginTransaction();
        session.remove(departamento);
        session.getTransaction().commit();
    }

}
