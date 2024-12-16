package acdat.hibernate.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@DiscriminatorValue("CC")
public class CuentaCredito extends Cuenta implements Serializable {

    double limiteCredito;

    public CuentaCredito(String titular, double balance, double tipoInteres, double limiteCredito) {
        super(titular, balance, tipoInteres);
        this.limiteCredito = limiteCredito;
    }

    public CuentaCredito() {}

    @Override
    public String toString() {
        return "CuentaCredito{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", balance=" + balance +
                ", tipoInteres=" + tipoInteres +
                ", limiteCredito=" + limiteCredito +
                '}';
    }
}
