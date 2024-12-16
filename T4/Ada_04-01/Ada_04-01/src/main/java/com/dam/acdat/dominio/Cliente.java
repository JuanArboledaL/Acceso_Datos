package com.dam.acdat.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_taller_fk",
            joinColumns = { @JoinColumn(name = "cliente_id") },
            inverseJoinColumns = { @JoinColumn(name = "taller_id") }
    )
    private List<Taller> talleres;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(int id, String nombre, Direccion direccion, List<Pedido> pedidos, List<Taller> talleres) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedidos = pedidos;
        this.talleres = talleres;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion.getId() +
                ", talleres=" + talleres +
                ", pedidos=" + pedidos +
                '}';
    }
}
