package dam.acdat.hibernate.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String ciudad;

    @OneToOne(mappedBy = "direccion", cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToOne(mappedBy = "direccion", cascade = CascadeType.ALL)
    private Taller taller;

    public Direccion() {}

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", cliente=" + cliente +
                ", taller=" + taller +
                '}';
    }
}