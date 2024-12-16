package dam.acdat.hibernate.dao;

import dam.acdat.hibernate.domain.Articulo;
import dam.acdat.hibernate.domain.Comprador;
import dam.acdat.hibernate.domain.Venta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ArticuloDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public ArticuloDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listarArticulos() {
        String hql = "SELECT a FROM Articulo a";
        Query query = session.createQuery(hql);
        List<Articulo> lista = query.getResultList();

        for (Articulo articulo : lista) {
            System.out.println(articulo);
        }
    }

    public void guardar(Articulo articulo) {
        session.beginTransaction();
        session.persist(articulo);
        session.getTransaction().commit();
    }
}