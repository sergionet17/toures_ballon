/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */
@Entity(name="PRODUCTO_ORDENES_TB")
public class ProductoOrdenes {

    @NotNull
    @Id
    private int codigoItem;
    @NotNull
    private int codigoProducto;
    @NotNull
    private String nombreProducto;
    @NotNull
    private String numeroParte;
    @NotNull
    private int precio;
    @NotNull
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "CODIGO_ORDEN")
    private OrdenVenta ordenVenta;

    public ProductoOrdenes(int codigoItem, int codigoProducto, String nombreProducto, String numeroParte, int precio, int cantidad, OrdenVenta ordenVenta) {
        this.codigoItem = codigoItem;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.numeroParte = numeroParte;
        this.precio = precio;
        this.cantidad = cantidad;
        this.ordenVenta = ordenVenta;
    }
    
    

    /**
     * @return the codigoItem
     */
    public int getCodigoItem() {
        return codigoItem;
    }

    /**
     * @param codigoItem the codigoItem to set
     */
    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    /**
     * @return the codigoProducto
     */
    public int getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the nombreProductoM
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProductoM the nombreProductoM to set
     */
    public void setNombreProductoM(String nombreProductoM) {
        this.nombreProducto = nombreProductoM;
    }

    /**
     * @return the numeroParte
     */
    public String getNumeroParte() {
        return numeroParte;
    }

    /**
     * @param numeroParte the numeroParte to set
     */
    public void setNumeroParte(String numeroParte) {
        this.numeroParte = numeroParte;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the ordenVenta
     */
    public OrdenVenta getOrdenVenta() {
        return ordenVenta;
    }

    /**
     * @param ordenVenta the ordenVenta to set
     */
    public void setOrdenVenta(OrdenVenta ordenVenta) {
        this.ordenVenta = ordenVenta;
    }

}
