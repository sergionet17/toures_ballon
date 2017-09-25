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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "Productos")
public class Producto {
    
    @NotNull
    @Id
    private int id;

    @NotNull
    private String espectaculo;
    @NotNull
    private Date fechaEspectaculo;
    @NotNull
    private int idCiudadEspectaculo;
    
    @NotNull
    private int precio;

    public Producto(int id, String espectaculo, Date fechaEspectaculo, int idCiudadEspectaculo, int precio) {
        this.id = id;
        this.espectaculo = espectaculo;
        this.fechaEspectaculo = fechaEspectaculo;
        this.idCiudadEspectaculo = idCiudadEspectaculo;
        this.precio = precio;
    }
    
    public Producto(){
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the espectaculo
     */
    public String getEspectaculo() {
        return espectaculo;
    }

    /**
     * @param espectaculo the espectaculo to set
     */
    public void setEspectaculo(String espectaculo) {
        this.espectaculo = espectaculo;
    }

    /**
     * @return the fechaEspectaculo
     */
    public Date getFechaEspectaculo() {
        return fechaEspectaculo;
    }

    /**
     * @param fechaEspectaculo the fechaEspectaculo to set
     */
    public void setFechaEspectaculo(Date fechaEspectaculo) {
        this.fechaEspectaculo = fechaEspectaculo;
    }

    /**
     * @return the idCiudadEspectaculo
     */
    public int getIdCiudadEspectaculo() {
        return idCiudadEspectaculo;
    }

    /**
     * @param idCiudadEspectaculo the idCiudadEspectaculo to set
     */
    public void setIdCiudadEspectaculo(int idCiudadEspectaculo) {
        this.idCiudadEspectaculo = idCiudadEspectaculo;
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
    
    
}
