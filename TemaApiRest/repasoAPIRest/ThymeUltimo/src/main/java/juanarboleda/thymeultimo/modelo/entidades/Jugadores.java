package juanarboleda.thymeultimo.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "jugadores")
public class Jugadores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugadores_id_gen")
    @SequenceGenerator(name = "jugadores_id_gen", sequenceName = "jugadores_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 25)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Size(max = 90)
    @Column(name = "posicion", length = 90)
    private String posicion;

    @Column(name = "dorsal")
    private Integer dorsal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("equipo")
    @JoinColumn(name = "equipo_id")
    private Equipos equipo;

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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

}