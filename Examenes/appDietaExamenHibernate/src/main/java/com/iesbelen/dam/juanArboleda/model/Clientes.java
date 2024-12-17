package com.iesbelen.dam.juanArboleda.model;

public class Clientes {

    private int nombre;
    private String fecha_nacimiento;
    private String telefono;
    private String email;
    private int centro_dietetico_id;

    public Clientes(int nombre, String fecha_nacimiento, String telefono, String email, int centro_dietetico_id) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
        this.centro_dietetico_id = centro_dietetico_id;
    }

    public int getNombre() {
        return nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getCentro_dietetico_id() {
        return centro_dietetico_id;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre=" + nombre +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", centro_dietetico_id=" + centro_dietetico_id +
                '}';
    }
}
