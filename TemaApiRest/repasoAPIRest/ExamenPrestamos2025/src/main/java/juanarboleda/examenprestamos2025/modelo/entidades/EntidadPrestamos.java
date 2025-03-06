package juanarboleda.examenprestamos2025.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
public class EntidadPrestamos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestamos_id_gen")
    @SequenceGenerator(name = "prestamos_id_gen", sequenceName = "prestamos_id_prestamo_seq", allocationSize = 1)
    @Column(name = "id_prestamo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("idLibro")
    @JoinColumn(name = "id_libro")
    private EntidadLibros idLibro;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference("idUsuario")
    @JoinColumn(name = "id_usuario")
    private EntidadUsuarios idUsuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EntidadLibros getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(EntidadLibros idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public EntidadUsuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(EntidadUsuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

}