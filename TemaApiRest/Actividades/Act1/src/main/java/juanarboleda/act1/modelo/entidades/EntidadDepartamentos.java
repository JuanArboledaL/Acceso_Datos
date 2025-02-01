package juanarboleda.act1.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "departamentos")
public class EntidadDepartamentos {
    @Id
    @NotEmpty
    @Column(name = "depno", nullable = false)
    private Integer id;

    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Size(min = 6, max = 14, message = "El nombre tiene que tener entre 6 y 14 carácteres")
    @Column(name = "nombre", length = 14)
    private String nombre;

    @NotEmpty(message = "El campo ubicación no puede estar vacio")
    @Size(min = 6, max = 13, message = "La ubicación tiene que tener entre 6 y 13 carácteres")
    @Column(name = "ubicacion", length = 13)
    private String ubicacion;

    @OneToMany(mappedBy = "depno")
    @JsonIgnoreProperties("depno")
    private Set<EntidadEmpleados> empleados = new LinkedHashSet<>();

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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<EntidadEmpleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<EntidadEmpleados> empleados) {
        this.empleados = empleados;
    }

}