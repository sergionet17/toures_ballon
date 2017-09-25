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
import netgloo.models.ProductoOrdenes;
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
    
    /*localhost:8080/createOrden?codigoOrden=123457&fecha=
            12/12/2017&precio=1234&estado=act&comentarios=piro
            &numeroDocCliente=1234567&tipoDocCliente=duro&codigoItem=12
            &codigoProducto=13&nombreProductoM=TEST&numeroParte=123&precio=1234&cantidad=21*/
    @RequestMapping(value = "/createOrden", method = RequestMethod.POST)
    @ResponseBody
    public String createCampana(@RequestParam("codigoOrden") int codigoOrden,
            @RequestParam("fecha") Date fecha, @RequestParam("precio") int precio,
            @RequestParam("estado") String estado, @RequestParam("comentarios") String comentarios,
            @RequestParam("numeroDocCliente") String numeroDocCliente, @RequestParam("tipoDocCliente") String tipoDocCliente,
            @RequestParam("codigoItem") int codigoItem,@RequestParam("codigoProducto") int codigoProducto,
            @RequestParam("nombreProductoM") String nombreProductoM,@RequestParam("numeroParte") String numeroParte,
            @RequestParam("precio") int tipoDocClienteProducto,@RequestParam("cantidad") int cantidad) {
        try {
            OrdenVenta ordenVenta = new OrdenVenta(codigoOrden, fecha, precio, estado, comentarios,
                    numeroDocCliente, tipoDocCliente);
            ProductoOrdenes ordenes = new ProductoOrdenes(codigoItem, 
                    codigoProducto, nombreProductoM, numeroParte, precio, cantidad, ordenVenta);
            ordenDao.create(ordenes);
        } catch (Exception ex) {
            return "Error creating the orden: " + ex.toString();
        }
        return "Orden succesfully created!";
    }
}
