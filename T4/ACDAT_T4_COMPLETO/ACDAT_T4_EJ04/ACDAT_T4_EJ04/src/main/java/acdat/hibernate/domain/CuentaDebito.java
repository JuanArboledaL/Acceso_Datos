package acdat.hibernate.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class CuentaDebito extends Cuenta implements Serializable {

    double cargoPorDescubierto;

    public CuentaDebito() {}

    public CuentaDebito(String titular, double balance, double tipoInteres, double cargoPorDescubierto) {
        super(titular, balance, tipoInteres);
        this.cargoPorDescubierto = cargoPorDescubierto;
    }

    @Override
    public String toString() {
        return "CuentaDebito{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", balance=" + balance +
                ", tipoInteres=" + tipoInteres +
                ", cargoPorDescubierto=" + cargoPorDescubierto +
                '}';
    }
}
