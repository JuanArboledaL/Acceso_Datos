package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "depno")
    private Integer id;

    @Column(name = "nombre", length = 14)
    private String nombre;

    @Column(name = "ubicacion", length = 13)
    private String ubicacion;

    @OneToMany(mappedBy = "depno", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Empleado> empleados = new LinkedHashSet<>();

    @Override
    public String toString() {
        String cadena = "";

        cadena += "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", empleados=";

        for (Empleado empleado : empleados) {
            cadena += "\n\t" + empleado.toStringSinInfo();
        }

        cadena += '}';

        return cadena;
    }

    public String toStringSinInfo() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + "'}";
    }
}