package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.Column;

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
