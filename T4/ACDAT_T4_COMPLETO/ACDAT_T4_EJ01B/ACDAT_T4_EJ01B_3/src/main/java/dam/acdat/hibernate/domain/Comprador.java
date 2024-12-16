package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compradores")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idComprador;

    private String nombre;

    private String telefono;

    public Comprador() {}

    public Comprador(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "idComprador=" + idComprador +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}