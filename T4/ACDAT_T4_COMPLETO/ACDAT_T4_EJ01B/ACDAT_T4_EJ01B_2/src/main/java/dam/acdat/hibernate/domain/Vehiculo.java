package dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String marca;

    private String modelo;

    private String color;

    private String matricula;

    @Temporal(TemporalType.DATE)
    private Date fechaMatriculacion;

    private long numeroKilometros;

    @ManyToOne
    @JoinColumn(name = "concesionarios_id")
    private Concesionario concesionario;

    public Vehiculo() {}

    public Vehiculo(String marca, String modelo, String color, String matricula, Date fechaMatriculacion, long numeroKilometros, Concesionario concesionario) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.numeroKilometros = numeroKilometros;
        this.concesionario = concesionario;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", matricula=" + matricula +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", numeroKilometros=" + numeroKilometros +
                ", concesionario=" + (concesionario != null ? concesionario.getNombreComercial() : "No asociado") +
                '}';
    }
}
