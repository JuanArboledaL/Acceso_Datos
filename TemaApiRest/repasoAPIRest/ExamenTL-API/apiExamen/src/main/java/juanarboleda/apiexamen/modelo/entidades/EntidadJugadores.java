package juanarboleda.apiexamen.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "jugadores")
public class EntidadJugadores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugadores_id_gen")
    @SequenceGenerator(name = "jugadores_id_gen", sequenceName = "jugadores_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message="El nombre no puede estar vacío")
    @Size(min = 5, max = 25, message = "El nombre tiene que tener entre 5 y 25 caracteres")
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "posicion", length = 90)
    private String posicion;


    @Min(value = 1, message = "El número debe ser mayor o igual a 1")
    @Max(value = 30, message = "El número debe ser menor o igual a 30")
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