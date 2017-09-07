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
  private String email;
  
  @NotNull
  private String name;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public Campaña() { }

  public Campaña(String email, String name) {
    this.email = email;
    this.name = name;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }
  
} // class User
