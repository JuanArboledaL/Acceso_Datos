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
@Table(name = "articulos")
public class Articulo {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precioVenta")
    private Long precioVenta;
}
