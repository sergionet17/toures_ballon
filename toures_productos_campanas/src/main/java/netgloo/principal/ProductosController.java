/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import netgloo.models.Campaña;
import netgloo.models.OrdenDao;
import netgloo.models.OrdenVenta;
import netgloo.models.Productos;
import netgloo.models.ProductoDao;
import netgloo.models.ProductoOrdenes;
import netgloo.models.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ProductosController {
        @Autowired
    private ProductoDao productoDao;
    
    /*?id=1&espectaculo=SERGIO&fecha=12/12/17&idCiudad=12&precio=123456*/
    @RequestMapping(value = "/createProducto", method = RequestMethod.POST)
    @ResponseBody
    public String createProductos(@RequestParam("id") int id,
            @RequestParam("espectaculo") String espectaculo,
            @RequestParam("fecha") Date fecha,
            @RequestParam("idCiudad") int idCiudad,
            @RequestParam("precio") int precio) {
        try {
           Productos producto = new Productos();
           productoDao.create(producto);
        } catch (Exception ex) {
            return "Error creating the orden: " + ex.toString();
        }
        return "Orden succesfully created!";
    }
    
       // Metodo para obtner la campaña segun el email
    //localhost:8080/user/12
    @RequestMapping(value = "/producto/{codigoProducto}", method = RequestMethod.GET)
    public Productos getProducto(@PathVariable("codigoProducto") int codigoProducto) throws IndexOutOfBoundsException {
        Productos productos = new Productos();
        try {
            List<Productos> listProducto = new ArrayList<Productos>();
            listProducto = productoDao.getByCodigoProduto(codigoProducto);
            productos = listProducto.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }
}
