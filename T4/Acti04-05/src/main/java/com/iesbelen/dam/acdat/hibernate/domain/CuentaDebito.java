package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CuentaDebito extends Cuenta {

    @Column(name = "CargoPorDecubierto")
    private double cargoPorDescubierto;

    public double getCargoPorDescubierto() {
        return cargoPorDescubierto;
    }

    public void setCargoPorDescubierto(double cargoPorDescubierto) {
        this.cargoPorDescubierto = cargoPorDescubierto;
    }
}
