/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergio
 */

@Entity(name="ProductosCampania")
public class ProductosCampania {
    @NotNull
    @Id
    private int productosCampania;
    @NotNull
    private int idCampania;

    public ProductosCampania(int idCampania) {
        this.idCampania = idCampania;       
    }
    @NotNull
    private int idProducto;

    public ProductosCampania() {
    }
    
    
    
    /**
     * @return the idCampania
     */
    public int getIdCampania() {
        return idCampania;
    }

    /**
     * @param idCampania the idCampania to set
     */
    public void setIdCampania(int idCampania) {
        this.idCampania = idCampania;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }



    
}
