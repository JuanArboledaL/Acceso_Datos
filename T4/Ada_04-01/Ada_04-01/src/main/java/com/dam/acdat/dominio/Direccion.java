package com.dam.acdat.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(mappedBy = "direccion")
    private Cliente cliente;

    @OneToOne(mappedBy = "direccion")
    private Taller taller;

    public Direccion() {
    }

    public Direccion(Taller taller, Cliente cliente, String direccion, int id) {
        this.taller = taller;
        this.cliente = cliente;
        this.direccion = direccion;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", cliente=" + cliente +
                ", taller=" + taller +
                '}';
    }
}
