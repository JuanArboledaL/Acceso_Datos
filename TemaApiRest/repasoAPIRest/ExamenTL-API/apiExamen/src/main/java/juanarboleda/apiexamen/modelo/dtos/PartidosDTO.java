package juanarboleda.apiexamen.modelo.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class PartidosDTO {

    private String nombreEquipoLocal;
    private String escudoEquipoLocal;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private LocalDate fecha;
    private LocalTime hora;

    public String getNombreEquipoLocal() {
        return nombreEquipoLocal;
    }

    public void setNombreEquipoLocal(String nombreEquipoLocal) {
        this.nombreEquipoLocal = nombreEquipoLocal;
    }

    public String getEscudoEquipoLocal() {
        return escudoEquipoLocal;
    }

    public void setEscudoEquipoLocal(String escudoEquipoLocal) {
        this.escudoEquipoLocal = escudoEquipoLocal;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
