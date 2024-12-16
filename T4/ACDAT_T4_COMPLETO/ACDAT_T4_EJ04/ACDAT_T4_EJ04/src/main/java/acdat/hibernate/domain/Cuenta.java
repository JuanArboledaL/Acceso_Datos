package acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String titular;

    double balance;

    double tipoInteres;

    public Cuenta() {}

    public Cuenta(String titular, double balance, double tipoInteres) {
        this.titular = titular;
        this.balance = balance;
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", balance=" + balance +
                ", tipoInteres=" + tipoInteres +
                '}';
    }

}
