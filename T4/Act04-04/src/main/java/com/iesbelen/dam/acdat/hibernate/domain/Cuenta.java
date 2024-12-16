package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cuenta  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "titular")
    private String titular;

    @Column(name = "Balance")
    private double balance;

    @Column(name = "TipoInteres")
    private double tipoInteres;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitular(String titulo) {
        this.titular = titulo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public long getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public double getBalance() {
        return balance;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }
}
