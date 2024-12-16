package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    @Column(name = "matriculacion")
    private String matriculacion;

    @Column(name = "fecha_matriculacion")
    @Temporal(TemporalType.DATE)
    private Date fechaMatriculacion;

    @Column(name = "numKilometros")
    private Long numeroKilometros;

    @ManyToOne(fetch = FetchType.LAZY)
    private Concesionario concesionario;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", matriculacion='" + matriculacion + '\'' +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", numeroKilometros=" + numeroKilometros +
                ", concesionario=" + concesionario +
                '}';
    }
}
