package acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departamentos")
@ToString(exclude="empleados")
public class Departamento {
    @Id
    @Column(name = "depno", nullable = false)
    private Integer id;

    @Column(name = "nombre_departamento", length = 14)
    private String nombreDepartamento;

    @Column(name = "ubicacion_departamento", length = 13)
    private String ubicacionDepartamento;

    @OneToMany(mappedBy = "depno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleados = new LinkedHashSet<>();

    public Departamento() {}

    @Override
    public String toString() {
        String cadena = "";

        cadena += "Departamento{" +
                "id=" + id +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                ", ubicacionDepartamento='" + ubicacionDepartamento + '\'' +
                ", empleados=";

        for (Empleado empleado : empleados) {
            cadena += empleado.toStringSinInfo();
        }

        cadena += '}';

        return cadena;
    }

    public String toStringSinInfo() {
        return "Departamento{" +
                "id=" + id +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                ", ubicacionDepartamento='" + ubicacionDepartamento + "'}";
    }
}