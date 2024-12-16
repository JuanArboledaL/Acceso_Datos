package com.dam.acdat.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taller_id")
    private Taller taller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int codigo, String descripcion, Taller taller, Cliente cliente) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.taller = taller;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", taller=" + taller.getId() +
                ", cliente=" + cliente.getId() +
                '}';
    }
}
