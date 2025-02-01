package juanarboleda.act1.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleados")
public class EntidadEmpleados {
    @Id
    @Column(name = "empno", nullable = false)
    private Integer id;

    @Basic
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Size(min = 3, max = 10, message = "El nombre tiene que tener entre 3 y 10 carácteres")
    @Column(name = "nombre", nullable = false, length = 10)
    private String nombre;

    @NotEmpty(message = "El campo puesto no puede estar vacio")
    @Size(min = 4, max = 15, message = "El puesto tiene que tener entre 4 y 15 carácteres")
    @Column(name = "puesto", nullable = false, length = 15)
    private String puesto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "depno", referencedColumnName = "depno", updatable = false, insertable = false)
    @JsonBackReference("empleados")
    private EntidadDepartamentos depno;

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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public EntidadDepartamentos getDepno() {
        return depno;
    }

    public void setDepno(EntidadDepartamentos depno) {
        this.depno = depno;
    }

}