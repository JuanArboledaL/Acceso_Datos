package juanarboleda.appbiblioteca2425.modelo.dto;

import jakarta.persistence.Entity;
import juanarboleda.appbiblioteca2425.modelo.entidades.EntidadLibros;

import java.util.LinkedHashSet;
import java.util.Set;


public class AutoresDTO {

    private Integer id;
    private String nombreAutor;
    private String pais;
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
