package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class

                                                                                                                                                              Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "clientes_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "talleres_id", nullable = false)
    private Taller taller;

    public Pedido() {}

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", cliente=" + cliente +
                ", taller=" + taller +
                '}';
    }
}