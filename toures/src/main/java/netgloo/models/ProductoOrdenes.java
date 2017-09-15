/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.models;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */
public class ProductoOrdenes {
    @NotNull
    @Id
    private int codigoItem;
    @NotNull
    private int codigoProducto;
    @NotNull
    private String nombreProductoM;
    @NotNull
    private String numeroParte;
    @NotNull
    private int precio;
    @NotNull
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private int codigoOrden;

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
    public String getNombreProductoM() {
        return nombreProductoM;
    }

    /**
     * @param nombreProductoM the nombreProductoM to set
     */
    public void setNombreProductoM(String nombreProductoM) {
        this.nombreProductoM = nombreProductoM;
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
     * @return the codigoOrden
     */
    public int getCodigoOrden() {
        return codigoOrden;
    }

    /**
     * @param codigoOrden the codigoOrden to set
     */
    public void setCodigoOrden(int codigoOrden) {
        this.codigoOrden = codigoOrden;
    }






}
