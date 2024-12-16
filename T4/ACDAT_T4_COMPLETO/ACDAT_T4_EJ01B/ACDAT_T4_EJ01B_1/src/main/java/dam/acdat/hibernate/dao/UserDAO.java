package dam.acdat.hibernate.dao;

import dam.acdat.hibernate.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO {

    private SessionFactory sessionFactory;
    private Session session;

    public UserDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listar() {
        String hlc = "SELECT u from User u";

        Query query = session.createQuery(hlc);
        List<User> lista = query.getResultList();

        for (User u : lista) {
            System.out.println(u);
        }
    }

}
