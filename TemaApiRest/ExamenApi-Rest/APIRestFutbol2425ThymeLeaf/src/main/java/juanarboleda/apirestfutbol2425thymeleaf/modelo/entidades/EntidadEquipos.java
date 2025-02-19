package juanarboleda.apirestfutbol2425thymeleaf.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "escudo")
    private String escudo;

    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference("jugadores")
    private Set<EntidadJugadores> jugadores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    @JsonBackReference("partidos")
    private Set<EntidadPartidos> partidos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoVisitante")
    @JsonBackReference("partido")
    private Set<EntidadPartidos> partido = new LinkedHashSet<>();

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

    public Set<EntidadJugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<EntidadJugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<EntidadPartidos> getPartidos() {
        return partidos;
    }

    public void setPartidos(Set<EntidadPartidos> partidos) {
        this.partidos = partidos;
    }

    public Set<EntidadPartidos> getPartido() {
        return partido;
    }

    public void setPartido(Set<EntidadPartidos> partido) {
        this.partido = partido;
    }

}