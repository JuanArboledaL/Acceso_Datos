package org.example.prestamosthymeleaf.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class EntidadUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_gen")
    @SequenceGenerator(name = "usuarios_id_gen", sequenceName = "usuarios_id_usuario_seq", allocationSize = 1)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @OneToMany(mappedBy = "idUsuario")
    @JsonBackReference("prestamos")
    private Set<EntidadPrestamos> prestamos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<EntidadPrestamos> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<EntidadPrestamos> prestamos) {
        this.prestamos = prestamos;
    }

}