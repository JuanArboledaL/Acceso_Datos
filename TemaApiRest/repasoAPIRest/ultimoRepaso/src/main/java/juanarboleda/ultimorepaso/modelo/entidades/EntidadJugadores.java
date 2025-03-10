package juanarboleda.ultimorepaso.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "jugadores")
public class EntidadJugadores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugadores_id_gen")
    @SequenceGenerator(name = "jugadores_id_gen", sequenceName = "jugadores_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(min = 5,max = 25, message = ("El nombre debe de estar comprendido con una cadena de 5 a 25 caracteres"))
    @NotNull
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Size(max = 90)
    @Column(name = "posicion", length = 90)
    private String posicion;

    @Min(value = 1, message = ("El número del dorsal debe de ser un número que se encuentre en el rango de 1 a 30 incluyendo ambos números"))
    @Max(value = 30, message = ("El número del dorsal debe de ser un número que se encuentre en el rango de 1 a 30 incluyendo ambos números"))
    @Column(name = "dorsal")
    private Integer dorsal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("equipo")
    @JoinColumn(name = "equipo_id")
    private EntidadEquipos equipo;

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

    public EntidadEquipos getEquipo() {
        return equipo;
    }

    public void setEquipo(EntidadEquipos equipo) {
        this.equipo = equipo;
    }

}