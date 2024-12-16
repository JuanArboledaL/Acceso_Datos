package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "direcciones_id", unique = true)
    private Direccion direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pedido> pedidos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "clientes_talleres",
            joinColumns = @JoinColumn(name = "clientes_id"),
            inverseJoinColumns = @JoinColumn(name = "talleres_id")
    )
    private Set<Taller> talleres = new HashSet<>();

    public Cliente() {}

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", pedidos=" + pedidos +
                ", talleres=" + talleres +
                '}';
    }
}
