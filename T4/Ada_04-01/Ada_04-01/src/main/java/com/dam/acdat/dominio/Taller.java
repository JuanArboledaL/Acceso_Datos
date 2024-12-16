package com.dam.acdat.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "talleres")
public class Taller {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    @ManyToMany(mappedBy = "talleres")
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "taller", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Taller() {
    }

    public Taller(int id, Direccion direccion, List<Cliente> clientes, List<Pedido> pedidos) {
        this.id = id;
        this.direccion = direccion;
        this.clientes = clientes;
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "id=" + id +
                ", direccion=" + direccion +
                ", clientes=" + clientes +
                ", pedidos=" + pedidos +
                '}';
    }
}
