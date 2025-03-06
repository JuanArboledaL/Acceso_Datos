package org.example.apirest_thymeleaf.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipos")
public class EntidadEquipos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipos_id_gen")
    @SequenceGenerator(name = "equipos_id_gen", sequenceName = "equipos_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Size(max = 255)
    @Column(name = "escudo")
    private String escudo;

    @OneToMany(mappedBy = "equipo")
    @JsonBackReference("jugadores")
    private Set<org.example.apirest_thymeleaf.modelo.entidades.EntidadJugadores> jugadores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    @JsonBackReference("partidos")
    private Set<org.example.apirest_thymeleaf.modelo.entidades.EntidadPartidos> partidos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public Set<org.example.apirest_thymeleaf.modelo.entidades.EntidadJugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<org.example.apirest_thymeleaf.modelo.entidades.EntidadJugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<org.example.apirest_thymeleaf.modelo.entidades.EntidadPartidos> getPartidos() {
        return partidos;
    }

    public void setPartidos(Set<org.example.apirest_thymeleaf.modelo.entidades.EntidadPartidos> partidos) {
        this.partidos = partidos;
    }

}