package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdenVenta {

    
    private int codigoOrden;
    
    private String fecha;
    
    private int precio;
  
    private String estado;
   
    private String comentarios;
    
    private String numeroDocCliente;
   
    private String tipoDocCliente;
    
    public OrdenVenta(){
        
    }
    
    public OrdenVenta(String estado){
        this.estado = estado;
    }

    public OrdenVenta(int codigoOrden, String fecha, int precio, String estado, String comentarios,
            String numeroDocCliente, String tipoDocCliente) {
        this.codigoOrden = codigoOrden;
        this.fecha = fecha;
        this.precio = precio;
        this.estado = estado;
        this.comentarios = comentarios;
        this.numeroDocCliente = numeroDocCliente;
        this.tipoDocCliente = tipoDocCliente;
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
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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
     * @return the tipoDocCliente
     */
    public String getTipoDocCliente() {
        return tipoDocCliente;
    }

    /**
     * @param tipoDocCliente the tipoDocCliente to set
     */
    public void setTipoDocCliente(String tipoDocCliente) {
        this.tipoDocCliente = tipoDocCliente;
    }

}
