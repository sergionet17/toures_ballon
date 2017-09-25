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
@Table(name = "Campanas_tb")
public class Campaña {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------
    @NotNull
    @Id
    private int codigo_campana;

    @NotNull
    private String nombre_campana;

    @NotNull
    private int codigo_producto;
    
    @NotNull
    private String fecha_inicio;
    
    @NotNull
    private String fecha_fin;
    
    @NotNull
    private String estado;
    
    @NotNull
    private String cantidad;
    
    @NotNull
    private String precio;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------
    public Campaña() {
    }
    
    public Campaña(int codigo_campana) {
        this.codigo_campana = codigo_campana;
    }

    public Campaña(int codigo_campana, String nombre_campana,int codigo_producto,
            String fecha_inicio, String fecha_fin, String estado,String cantidad,String precio) {
        this.codigo_campana = codigo_campana;
        this.nombre_campana = nombre_campana;
        this.codigo_producto = codigo_producto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigo_campana() {
        return codigo_campana;
    }

    public void setId(int codigo_campana) {
        this.setCodigo_campana(codigo_campana);
    }

    public String getNombre_campana() {
        return nombre_campana;
    }

    public void setNombre_campana(String nombre) {
        this.nombre_campana = nombre;
    }

    /**
     * @return the value
     */
    public int getCodigo_producto() {
        return codigo_producto;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int codigo_producto) {
        this.setCodigo_producto(codigo_producto);
    }

    /**
     * @param codigo_campana the codigo_campana to set
     */
    public void setCodigo_campana(int codigo_campana) {
        this.codigo_campana = codigo_campana;
    }

    /**
     * @param codigo_producto the codigo_producto to set
     */
    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    /**
     * @return the fecha_inicio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @return the fecha_fin
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
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
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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

  

} // class User
