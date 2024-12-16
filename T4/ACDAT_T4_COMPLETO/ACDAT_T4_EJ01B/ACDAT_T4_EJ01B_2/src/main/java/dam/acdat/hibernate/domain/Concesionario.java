package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "concesionarios")
public class Concesionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombreComercial;

    private String nombreEmpresarial;

    private String direccionConcesionario;

    private int numTrabajadores;

    private String email;

    @OneToMany(mappedBy = "concesionario", cascade = CascadeType.MERGE)
    private List<Vehiculo> vehiculos;

    public Concesionario() {
        vehiculos = new ArrayList<>();
    }

    public Concesionario(String nombreComercial, String nombreEmpresarial, String direccionConcesionario, int numTrabajadores, String email) {
        this.nombreComercial = nombreComercial;
        this.nombreEmpresarial = nombreEmpresarial;
        this.direccionConcesionario = direccionConcesionario;
        this.numTrabajadores = numTrabajadores;
        this.email = email;
        vehiculos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Concesionario{" +
                "id=" + id +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", nombreEmpresarial='" + nombreEmpresarial + '\'' +
                ", direccionConcesionario='" + direccionConcesionario + '\'' +
                ", numTrabajadores=" + numTrabajadores +
                ", email='" + email + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
