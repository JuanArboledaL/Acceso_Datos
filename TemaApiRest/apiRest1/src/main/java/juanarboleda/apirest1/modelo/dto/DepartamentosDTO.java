package juanarboleda.apirest1.modelo.dto;

public class DepartamentosDTO {

    private int depNo;
    private String nombre;
    private String ubicacion;

    public int getDepNo() {return depNo;}

    public void setDepNo(int depNo) {
        this.depNo = depNo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
