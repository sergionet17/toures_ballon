package netgloo.models;

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
@Table(name = "Campaña")
public class Campaña {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------
    @NotNull
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private int value;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------
    public Campaña() {
    }
    
    public Campaña(String id) {
        this.id = id;
    }

    public Campaña(String id, String name,int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

  

} // class User
