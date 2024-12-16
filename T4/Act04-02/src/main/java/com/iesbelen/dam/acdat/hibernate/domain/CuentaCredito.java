package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class CuentaCredito extends Cuenta implements Serializable {

    @Column(name = "LimiteCredito")
    private double limiteCredito;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}