package acdat;

import acdat.hibernate.domain.CuentaCredito;
import acdat.hibernate.domain.CuentaDebito;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            CuentaCredito cuentaCredito = new CuentaCredito();
            cuentaCredito.setTitular("Luismi");
            cuentaCredito.setBalance(500.0);
            cuentaCredito.setTipoInteres(0.20);
            cuentaCredito.setLimiteCredito(600.0);

            CuentaDebito cuentaDebito = new CuentaDebito();
            cuentaDebito.setTitular("Luismi");
            cuentaDebito.setBalance(200.0);
            cuentaDebito.setTipoInteres(0.10);
            cuentaDebito.setCargoPorDescubierto(6.5);

            session.persist(cuentaCredito);
            session.persist(cuentaDebito);

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
            sessionFactory.close();
        }
    }
}