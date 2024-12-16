package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "concesionarios")
public class Concesionario {

    @Id
    @Column(name = "nombreComercial")
    private String nombreComercial;

    @Column(name = "nombreEmpresarial")
    private String nombreEmpresarial;

    @Column(name = "direccion")
    private String direccionConcesionario;

    @Column(name = "numTrabajadores")
    private int numTrabajadores;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "concesionario", cascade = CascadeType.REMOVE)
    private List<Vehiculo> coches = new ArrayList<Vehiculo>();

    @Override
    public String toString() {
        return "Concesionario{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nombreEmpresarial='" + nombreEmpresarial + '\'' +
                ", direccionConcesionario='" + direccionConcesionario + '\'' +
                ", numTrabajadores=" + numTrabajadores +
                ", email='" + email + '\'' +
                ", coches=" + coches +
                '}';
    }
}
