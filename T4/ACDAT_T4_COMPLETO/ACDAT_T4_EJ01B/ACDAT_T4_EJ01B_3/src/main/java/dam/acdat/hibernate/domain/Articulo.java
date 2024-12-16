package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idArticulo;

    private String descripcion;

    private long precioVenta;

    public Articulo() {}

    public Articulo(String descripcion, long precioVenta) {
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "idArticulo=" + idArticulo +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                '}';
    }
}