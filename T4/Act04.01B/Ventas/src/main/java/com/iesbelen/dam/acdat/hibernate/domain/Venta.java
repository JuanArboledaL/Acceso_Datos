package com.iesbelen.dam.acdat.hibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ventas")
public class Venta {

    @Id
    @Column(name = "unidadesVendidas")
    private int unidadesVendidas;
}
