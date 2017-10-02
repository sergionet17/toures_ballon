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
public class Productos {
    
    @NotNull
    @Id
    private int CodigoProducto;

    @NotNull
    private String NombreProducto;
    @NotNull
    private String FechaEvento;
    @NotNull
    private int idCiudad;
    
    @NotNull
    private int Precio;
    
    @NotNull
    private String ImageName;
    
    @NotNull
    private byte[] BinaryFile;

    /**
     * @return the CodigoProducto
     */
    public int getCodigoProducto() {
        return CodigoProducto;
    }

    /**
     * @param CodigoProducto the CodigoProducto to set
     */
    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    /**
     * @return the NombreProducto
     */
    public String getNombreProducto() {
        return NombreProducto;
    }

    /**
     * @param NombreProducto the NombreProducto to set
     */
    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    /**
     * @return the FechaEvento
     */
    public String getFechaEvento() {
        return FechaEvento;
    }

    /**
     * @param FechaEvento the FechaEvento to set
     */
    public void setFechaEvento(String FechaEvento) {
        this.FechaEvento = FechaEvento;
    }

    /**
     * @return the idCiudad
     */
    public int getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the Precio
     */
    public int getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the ImageName
     */
    public String getImageName() {
        return ImageName;
    }

    /**
     * @param ImageName the ImageName to set
     */
    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }

    

  
}
