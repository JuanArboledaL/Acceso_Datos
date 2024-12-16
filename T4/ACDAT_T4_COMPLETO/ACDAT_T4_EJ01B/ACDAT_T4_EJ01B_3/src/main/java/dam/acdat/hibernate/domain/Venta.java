package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVenta;

    @ManyToOne
    @JoinColumn(name = "compradores_idComprador")
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "articulos_idArticulo")
    private Articulo articulo;

    private int unidadesVendidas;

    public Venta() {}

    public Venta(Comprador comprador, Articulo articulo, int unidadesVendidas) {
        this.comprador = comprador;
        this.articulo = articulo;
        this.unidadesVendidas = unidadesVendidas;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", comprador=" + comprador +
                ", articulo=" + articulo +
                ", unidadesVendidas=" + unidadesVendidas +
                '}';
    }
}