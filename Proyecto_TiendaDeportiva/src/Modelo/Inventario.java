
package Modelo;

import java.util.Date;


public class Inventario {
    private int idInventario;
    private int idProducto;
    private int idProveedor;
    private int cantidadInventario;
    private Date fechaIngresoInventario;

    public Inventario(int idInventario, int idProducto, int idProveedor, int cantidadInventario, Date fechaIngresoInventario) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.cantidadInventario = cantidadInventario;
        this.fechaIngresoInventario = fechaIngresoInventario;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public Date getFechaIngresoInventario() {
        return fechaIngresoInventario;
    }

    public void setFechaIngresoInventario(Date fechaIngresoInventario) {
        this.fechaIngresoInventario = fechaIngresoInventario;
    }
    
    
    
}