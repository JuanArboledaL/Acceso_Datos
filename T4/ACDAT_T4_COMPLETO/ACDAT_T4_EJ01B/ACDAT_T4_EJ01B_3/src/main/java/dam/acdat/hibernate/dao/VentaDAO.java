package dam.acdat.hibernate.dao;

import dam.acdat.hibernate.domain.Comprador;
import dam.acdat.hibernate.domain.Venta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class VentaDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public VentaDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listarVenta() {
        String hql = "SELECT v FROM Venta v";
        Query query = session.createQuery(hql);
        List<Venta> lista = query.getResultList();

        for (Venta venta : lista) {
            System.out.println(venta);
        }
    }

    public void guardar(Venta venta) {
        session.beginTransaction();
        session.persist(venta);
        session.getTransaction().commit();
    }

}