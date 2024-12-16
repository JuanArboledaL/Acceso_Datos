package dam.acdat;


import dam.acdat.hibernate.dao.ArticuloDAO;
import dam.acdat.hibernate.dao.CompradorDAO;
import dam.acdat.hibernate.dao.VentaDAO;
import dam.acdat.hibernate.domain.Articulo;
import dam.acdat.hibernate.domain.Comprador;
import dam.acdat.hibernate.domain.Venta;

public class Main {
    public static void main(String[] args) {

        CompradorDAO compradorDAO = new CompradorDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();
        VentaDAO ventaDAO = new VentaDAO();

        Comprador comprador = new Comprador("Juan Pérez", "123456789");
        compradorDAO.guardar(comprador);

        Articulo articulo = new Articulo("Toyota Corolla 2024", 250000);
        articuloDAO.guardar(articulo);

        Venta venta = new Venta(comprador, articulo, 1);
        ventaDAO.guardar(venta);

        compradorDAO.listarCompradores();
        articuloDAO.listarArticulos();
        ventaDAO.listarVenta();

    }
}