/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */
@Entity(name="PRODUCTO_ORDENES_TB")
public class ProductoOrdenes {

    @SequenceGenerator(name="seq",sequenceName = "S_PRODUCTOS")
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "seq") 
    @Id
    private int codigoItem;
    @NotNull
    private int codigoProducto;
    //@NotNull
    //private String nombreProducto;
    @NotNull
    private int precio;
    @NotNull
    private int cantidad;
    @NotNull
    private int codigoOrdenProd;
    
    @NotNull
    @Column(name = "COD_PROVEEDOR_TRANS")
    private int codigoProveedorTrans;

    @NotNull
    @Column(name = "NUMERO_RESERVE_TRANS")
    private int numeroRerserveTrans;

    @NotNull
    @Column(name = "COD_PROVEEDOR_ALOJ")
    private int codProveedorAloj;
    
    @NotNull
    @Column(name = "NUMERO_RESERVE_ALOJ")
    private int numeroReserveAloj;

    
    public ProductoOrdenes(int codigoItem, 
            int codigoProducto, 
            String nombreProducto, String numeroParte, 
            int precio, int cantidad,int codigoOrdenProd) {
        this.codigoItem = codigoItem;
        this.codigoProducto = codigoProducto;
      //  this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigoOrdenProd = codigoOrdenProd;
    }
    
    public ProductoOrdenes(){}
    

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
    //public String getNombreProducto() {
    //    return nombreProducto;
   // }

    /**
     * @param nombreProductoM the nombreProductoM to set
     */
    //public void setNombreProductoM(String nombreProductoM) {
    //    this.nombreProducto = nombreProductoM;
    //}


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
   public int getCodigoOrdenProd() {
        return codigoOrdenProd;
   }

    /**
     * @param ordenVenta the ordenVenta to set
     */
    public void setCodigoOrdenProd(int codigoOrdenProd) {
        this.codigoOrdenProd = codigoOrdenProd;
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
