package com.iesbelen.dam.juanArboleda.model;

import java.util.Objects;

public class CentrosDieteticos {


    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String horario;

    public CentrosDieteticos() {

    }

    public CentrosDieteticos(String nombre, String direccion, String telefono, String email, String horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.horario = horario;
    }

    public static void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "CentrosDieteticos{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }

}
