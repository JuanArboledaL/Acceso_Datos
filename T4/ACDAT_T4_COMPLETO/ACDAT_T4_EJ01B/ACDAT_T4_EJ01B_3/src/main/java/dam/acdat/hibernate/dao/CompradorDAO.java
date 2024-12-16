package dam.acdat.hibernate.dao;

import dam.acdat.hibernate.domain.Comprador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CompradorDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public CompradorDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listarCompradores() {
        String hql = "SELECT c FROM Comprador c";
        Query query = session.createQuery(hql);
        List<Comprador> lista = query.getResultList();

        for (Comprador comprador : lista) {
            System.out.println(comprador);
        }
    }

    public void guardar(Comprador comprador) {
        session.beginTransaction();
        session.persist(comprador);
        session.getTransaction().commit();    }

}