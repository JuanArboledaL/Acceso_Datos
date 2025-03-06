package juanarboleda.apiexamen.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("jugadores")
    private Set<EntidadJugadores> jugadores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    @JsonBackReference("partidoLocal")
    private Set<EntidadPartidos> partidoLocal = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoVisitante")
    @JsonBackReference("partidoVisitante")
    private Set<EntidadPartidos> partidoVisante = new LinkedHashSet<>();

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

    public Set<EntidadPartidos> getPartidoLocal() {
        return partidoLocal;
    }

    public void setPartidoLocal(Set<EntidadPartidos> partidoLocal) {
        this.partidoLocal = partidoLocal;
    }

    public Set<EntidadPartidos> getPartidoVisante() {
        return partidoVisante;
    }

    public void setPartidoVisante(Set<EntidadPartidos> partidoVisante) {
        this.partidoVisante = partidoVisante;
    }

}