package acdat.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "empleados")
@ToString(exclude="depno")
public class Empleado {
    @Id
    @Column(name = "empno", nullable = false)
    private Integer id;

    @Column(name = "nombre_empleado", length = 10)
    private String nombreEmpleado;

    @Column(name = "puesto_empleado", length = 15)
    private String puestoEmpleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depno_id")
    private Departamento depno;

    public Empleado() {}

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", puestoEmpleado='" + puestoEmpleado + '\'' +
                ", depno=" + depno.toStringSinInfo() +
                '}';
    }

    public String toStringSinInfo() {
        return "Empleado{" +
                "id=" + id +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", puestoEmpleado='" + puestoEmpleado + '\'' +
                '}';
    }
}