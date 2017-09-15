/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import java.util.Date;
import netgloo.models.Campaña;
import netgloo.models.CampañaDao;
import netgloo.models.OrdenDao;
import netgloo.models.OrdenVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sergio
 */
@RestController
public class OrdenController {
    
    @Autowired
    private OrdenDao ordenDao;
    
    @RequestMapping(value = "/createOrden", method = RequestMethod.POST)
    @ResponseBody
    public String createCampana(@RequestParam("codigoOrden") int codigoOrden,
            @RequestParam("fecha") Date fecha, @RequestParam("precio") int precio,
            @RequestParam("estado") String estado, @RequestParam("comentarios") String comentarios,
            @RequestParam("numeroDocCliente") String numeroDocCliente, @RequestParam("tipoDocCliente") String tipoDocCliente) {
        try {
            OrdenVenta ordenVenta = new OrdenVenta(codigoOrden, fecha, precio, estado, comentarios,
                    numeroDocCliente, tipoDocCliente);
            ordenDao.create(ordenVenta);
        } catch (Exception ex) {
            return "Error creating the orden: " + ex.toString();
        }
        return "Orden succesfully created!";
    }
}
