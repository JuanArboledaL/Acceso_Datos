package juanarboleda.springthymeleafclase.modelo.entidades;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "departamentos")
public class EntidadDepartamentos {
    @Id
    @Column(name = "depno", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 14)
    private String nombre;

    @Column(name = "ubicacion", length = 13)
    private String ubicacion;

    @OneToMany(mappedBy = "depno")
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