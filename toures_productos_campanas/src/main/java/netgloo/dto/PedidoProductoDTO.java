/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.dto;

/**
 *
 * @author sergio
 */
public class PedidoProductoDTO {
    
    private int codigoItem;
    private int codigoProducto;
    private String precio;
    private String cantidad;
    private String numeroDocCliente;
    private int codigoProveedorTrans;
    private int numeroRerserveTrans;
    private int codProveedorAloj;
    private int numeroReserveAloj;

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
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the numeroDocCliente
     */
    public String getNumeroDocCliente() {
        return numeroDocCliente;
    }

    /**
     * @param numeroDocCliente the numeroDocCliente to set
     */
    public void setNumeroDocCliente(String numeroDocCliente) {
        this.numeroDocCliente = numeroDocCliente;
    }

    /**
     * @return the codigoProveedorTrans
     */
    public int getCodigoProveedorTrans() {
        return codigoProveedorTrans;
    }

    /**
     * @param codigoProveedorTrans the codigoProveedorTrans to set
     */
    public void setCodigoProveedorTrans(int codigoProveedorTrans) {
        this.codigoProveedorTrans = codigoProveedorTrans;
    }

    /**
     * @return the numeroRerserveTrans
     */
    public int getNumeroRerserveTrans() {
        return numeroRerserveTrans;
    }

    /**
     * @param numeroRerserveTrans the numeroRerserveTrans to set
     */
    public void setNumeroRerserveTrans(int numeroRerserveTrans) {
        this.numeroRerserveTrans = numeroRerserveTrans;
    }

    /**
     * @return the codProveedorAloj
     */
    public int getCodProveedorAloj() {
        return codProveedorAloj;
    }

    /**
     * @param codProveedorAloj the codProveedorAloj to set
     */
    public void setCodProveedorAloj(int codProveedorAloj) {
        this.codProveedorAloj = codProveedorAloj;
    }

    /**
     * @return the numeroReserveAloj
     */
    public int getNumeroReserveAloj() {
        return numeroReserveAloj;
    }

    /**
     * @param numeroReserveAloj the numeroReserveAloj to set
     */
    public void setNumeroReserveAloj(int numeroReserveAloj) {
        this.numeroReserveAloj = numeroReserveAloj;
    }   
}