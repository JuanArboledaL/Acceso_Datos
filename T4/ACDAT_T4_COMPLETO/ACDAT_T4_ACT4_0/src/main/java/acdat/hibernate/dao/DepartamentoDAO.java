package acdat.hibernate.dao;

import acdat.hibernate.domain.Departamento;
import acdat.hibernate.domain.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public void listarDepartamento() {
        String hql = "SELECT d FROM Departamento d";
        Query query = session.createQuery(hql);
        List<Departamento> lista = query.getResultList();

        for (Departamento departamento : lista) {
            System.out.println(departamento);
        }
    }

}
