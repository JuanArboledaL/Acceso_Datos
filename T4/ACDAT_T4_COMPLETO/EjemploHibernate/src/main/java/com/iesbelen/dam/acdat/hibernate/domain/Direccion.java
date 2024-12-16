package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "direccion", length = 80, nullable = false)
    private String direccion;

    public Direccion() {}

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
