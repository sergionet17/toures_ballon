/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import java.util.ArrayList;
import java.util.List;
import netgloo.models.OrdenDao;
import netgloo.models.OrdenVenta;
import netgloo.models.OrdenVentaDao;
import netgloo.models.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sergio
 */
//TODO
@RestController
public class OrdenVentaController {

    @Autowired
    private OrdenVentaDao ordenVentaDao;

    @RequestMapping(value = "/getOrdenVenta/{codigo_orden}", method = RequestMethod.GET)
    @ResponseBody
    public OrdenVenta getOrdenVenta(@PathVariable("codigo_orden") int codigo_orden) throws IndexOutOfBoundsException {
        OrdenVenta ordenVenta = new OrdenVenta();
        try {
            List<OrdenVenta> listProducto = new ArrayList<OrdenVenta>();
            listProducto = ordenVentaDao.getByCodigoOrdenVenta(codigo_orden);
            ordenVenta = listProducto.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordenVenta;
    }

    @RequestMapping(value = "/setOrdenVenta/{idOdenVenta}", method = RequestMethod.PUT)
    public String updateCanceladoVuelo(@PathVariable("idOdenVenta") int idOdenVenta) {
        OrdenVenta ordenVenta = new OrdenVenta();
        List<OrdenVenta> listProducto = new ArrayList<OrdenVenta>();
        listProducto = ordenVentaDao.getByCodigoOrdenVenta(idOdenVenta);
        ordenVenta = listProducto.get(0); 
        ordenVenta.setEstado("Cancelado");
        ordenVentaDao.update(ordenVenta);
        return "200";
    }
}
