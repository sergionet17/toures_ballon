package netgloo.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "Campanas_tb")
public class Campaña {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------
    @NotNull
    @Id
    private int idCampania;

    @NotNull
    private String Campania;

    @NotNull
    private String fchInicio;
    
    @NotNull
    private String fchFin;
    
    @NotNull
    private String Imagen;
    

    // ------------------------
    // PUBLIC METHODS
    // ------------------------
    public Campaña(int idCampania) {
        this.idCampania = idCampania;
    }
    
     public Campaña() {
        
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
     * @return the Campania
     */
    public String getCampania() {
        return Campania;
    }

    /**
     * @param Campania the Campania to set
     */
    public void setCampania(String Campania) {
        this.Campania = Campania;
    }

    /**
     * @return the fchInicio
     */
    public String getFchInicio() {
        return fchInicio;
    }

    /**
     * @param fchInicio the fchInicio to set
     */
    public void setFchInicio(String fchInicio) {
        this.fchInicio = fchInicio;
    }

    /**
     * @return the fchFin
     */
    public String getFchFin() {
        return fchFin;
    }

    /**
     * @param fchFin the fchFin to set
     */
    public void setFchFin(String fchFin) {
        this.fchFin = fchFin;
    }

    /**
     * @return the Imagen
     */
    public String getImagen() {
        return Imagen;
    }

    /**
     * @param Imagen the Imagen to set
     */
    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

  

} // class User
