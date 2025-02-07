package juanarboleda.appbiblioteca2425.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "autores")
public class EntidadAutores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autores_id_gen")
    @SequenceGenerator(name = "autores_id_gen", sequenceName = "autores_id_autor_seq", allocationSize = 1)
    @Column(name = "id_autor", nullable = false)
    private Integer id;

    @Column(name = "nombre_autor")
    private String nombreAutor;

    @Column(name = "pais", length = 50)
    private String pais;

    @OneToMany(mappedBy = "idAutor")
    @JsonBackReference("libros")
    private Set<EntidadLibros> libros = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<EntidadLibros> getLibros() {
        return libros;
    }

    public void setLibros(Set<EntidadLibros> libros) {
        this.libros = libros;
    }

}