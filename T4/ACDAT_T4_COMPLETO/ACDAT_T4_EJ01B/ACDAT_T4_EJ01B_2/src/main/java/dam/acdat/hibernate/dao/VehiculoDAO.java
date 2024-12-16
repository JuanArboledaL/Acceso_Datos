package dam.acdat.hibernate.dao;

import dam.acdat.hibernate.domain.Vehiculo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class VehiculoDAO {

    private final SessionFactory sessionFactory;
    private final Session session;

    public VehiculoDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listarVehiculos() {
        String hql = "SELECT v FROM Vehiculo v";
        Query query = session.createQuery(hql);
        List<Vehiculo> lista = query.getResultList();

        for (Vehiculo vehiculo : lista) {
            System.out.println(vehiculo);
        }
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        session.beginTransaction();
        session.persist(vehiculo);
        session.getTransaction().commit();
    }
}
