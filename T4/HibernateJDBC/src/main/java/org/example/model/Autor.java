package org.example.model;

import java.util.Set;

public class Autor {

    private Long id;

    private String nombre;

    private Set<Libro> libros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    public Autor() {

    }

    public Autor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String cadena = "Autor" +
                "id=" + id +
                ", nombre='" + nombre + '\'';


        for (Libro libro : libros) {
            cadena += "\n\t" + libro.toStringSinInfo();
        }

        return cadena;
    }

    public String toStringSinInfo() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
