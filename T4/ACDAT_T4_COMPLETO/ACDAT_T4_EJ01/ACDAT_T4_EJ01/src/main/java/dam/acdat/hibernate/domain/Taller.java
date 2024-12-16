package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "talleres")
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "direcciones_id", unique = true)
    private Direccion direccion;

    @OneToMany(mappedBy = "taller", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pedido> pedidos = new HashSet<>();

    @ManyToMany(mappedBy = "talleres")
    private Set<Cliente> clientes = new HashSet<>();

    public Taller() {}

    @Override
    public String toString() {
        return "Taller{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", pedidos=" + pedidos +
                ", clientes=" + clientes +
                '}';
    }
}