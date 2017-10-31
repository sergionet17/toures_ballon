/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import netgloo.dto.OrdenDTO;
import netgloo.models.Campaña;
import netgloo.models.CampañaDao;
import netgloo.models.OrdenDao;
import netgloo.models.OrdenVenta;
import netgloo.dto.PedidoProductoDTO;
import netgloo.models.ProductoOrdenes;
import netgloo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/createOrden", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String createOrden(@RequestBody List<PedidoProductoDTO> pedidoProductoDTORequest) throws SQLException {
        int n = 1000;
        int numero = (int) (Math.random() * n) + 1;

        try {

            OrdenVenta ordenVenta = new OrdenVenta();
            ordenVenta.setCodigoOrden(numero);
            ordenVenta.setComentarios("1");
            ordenVenta.setEstado("1");
            ordenVenta.setFecha("12-12-2017");
            ordenVenta.
                    setNumeroDocCliente(pedidoProductoDTORequest.get(0).getNumeroDocCliente());
            ordenVenta.setPrecio(12);
            ordenVenta.setTipoDocCliente("VIP");
            ordenDao.create(ordenVenta);

            for (PedidoProductoDTO pedidoProductoDTO : pedidoProductoDTORequest) {
                ProductoOrdenes productoOrdenes = new ProductoOrdenes();
                productoOrdenes.setCantidad(pedidoProductoDTO.getCantidad());
                productoOrdenes.setCodigoProducto(pedidoProductoDTO.getCodigoProducto());
                productoOrdenes.setPrecio(pedidoProductoDTO.getPrecio());
                productoOrdenes.setCodigoOrdenProd(numero);
                ordenDao.createProduct(productoOrdenes);
            }

        } catch (Exception ex) {
            return "Error creating the orden: " + ex.toString();
        }
        return "Orden creada con exito su numero de orden es: " + numero + "  ";
    }

    @RequestMapping(value = "/getOrdenes/{cedula}", method = RequestMethod.GET)
    public List<OrdenDTO> obtenerOrdenes(@PathVariable("cedula") int cedula) {
        List<OrdenDTO> ordenDTOs = new ArrayList<OrdenDTO>();
        List<OrdenVenta> ordenVentas = new ArrayList<OrdenVenta>();

        ordenVentas = ordenDao.getAllOrdenes(cedula);

        for (OrdenVenta ordenVenta : ordenVentas) {
            OrdenDTO ordenDTO = new OrdenDTO();
            ordenDTO.setEstado(Util.numerToState(ordenVenta.getEstado()));
            ordenDTO.setFecha(ordenVenta.getFecha());
            ordenDTO.setCodigoOrden(ordenVenta.getCodigoOrden());
            ordenDTOs.add(ordenDTO);
        }

        return ordenDTOs;
    }

    @RequestMapping(value = "/deleteOrden/{codigoOrden}", method = RequestMethod.DELETE)
    public String deleteOrden(@PathVariable("codigoOrden") int codigoOrden) throws IndexOutOfBoundsException {
        try {
            List<ProductoOrdenes> productoOrdenes = new ArrayList<ProductoOrdenes>();
            OrdenVenta ordenVenta = new OrdenVenta();
            productoOrdenes = ordenDao.getProductoByCodigoOrden(codigoOrden);

            for (ProductoOrdenes ordenes : productoOrdenes) {
                ordenDao.deleteProduct(ordenes);
            }
            ordenVenta = ordenDao.getOdenVentaByCodigoOrden(codigoOrden);
            ordenDao.deleteOrder(ordenVenta);
        } catch (Exception e) {
            e.printStackTrace();
            return "No existe una campaña con el id referenciado";
        }
        return "Se elimino la campana correctamente";
    }

}
