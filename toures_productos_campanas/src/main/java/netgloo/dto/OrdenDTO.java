/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.dto;

import java.util.List;
import netgloo.models.ProductoOrdenes;

/**
 *
 * @author sergio
 */
public class OrdenDTO {
    
    private int codigoOrden;
    private String fecha;
    private String estado;
    private List<ProductoOrdenes> lstProdutoOrdenes;

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

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the lstProdutoOrdenes
     */
    public List<ProductoOrdenes> getLstProdutoOrdenes() {
        return lstProdutoOrdenes;
    }

    /**
     * @param lstProdutoOrdenes the lstProdutoOrdenes to set
     */
    public void setLstProdutoOrdenes(List<ProductoOrdenes> lstProdutoOrdenes) {
        this.lstProdutoOrdenes = lstProdutoOrdenes;
    }
    
}
