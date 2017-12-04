/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.free.pojo;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author sergio
 */
public class Producto {

    private String nombre;
    private String id;
    private String codigo;
    private int cantidad;
    private int codigoProducto;
    private String descripcion;
    private String fechaFin;
    private String fechaIni;
    private String precio;
    private int proveedorHotele;
    private int proveedorTrans;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the fechaIni
     */
    public String getFechaIni() {
        return fechaIni;
    }

    /**
     * @param fechaIni the fechaIni to set
     */
    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
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
     * @return the proveedorHotele
     */
    public int getProveedorHotele() {
        return proveedorHotele;
    }

    /**
     * @param proveedorHotele the proveedorHotele to set
     */
    public void setProveedorHotele(int proveedorHotele) {
        this.proveedorHotele = proveedorHotele;
    }

    /**
     * @return the proveedorTrans
     */
    public int getProveedorTrans() {
        return proveedorTrans;
    }

    /**
     * @param proveedorTrans the proveedorTrans to set
     */
    public void setProveedorTrans(int proveedorTrans) {
        this.proveedorTrans = proveedorTrans;
    }

}
