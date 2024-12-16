package dam.acdat.hibernate.dao;

import dam.acdat.hibernate.domain.Concesionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ConcesionarioDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public ConcesionarioDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listarConcesionarios() {
        String hql = "SELECT c FROM Concesionario c";
        Query query = session.createQuery(hql);
        List<Concesionario> lista = query.getResultList();

        for (Concesionario concesionario : lista) {
            System.out.println(concesionario.toString());
        }
    }

    public void guardarConcesionario(Concesionario concesionario) {
        session.beginTransaction();
        session.persist(concesionario);
        session.getTransaction().commit();    }
}
