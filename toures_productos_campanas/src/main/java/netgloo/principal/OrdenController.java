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
        int nHotelReserva = 1000;
        int numeroHotel = (int) (Math.random() * nHotelReserva) + 1;
        int nTrasporte = 1000;
        int numeroTransporte = (int) (Math.random() * nTrasporte) + 1;

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
                productoOrdenes.setCodProveedorAloj(pedidoProductoDTO.getCodProveedorAloj());
                productoOrdenes.setCodigoProveedorTrans(pedidoProductoDTO.getCodigoProveedorTrans());
                productoOrdenes.setNumeroRerserveTrans(numeroTransporte);
                productoOrdenes.setNumeroReserveAloj(numeroHotel);
                ordenDao.createProduct(productoOrdenes);
            }

        } catch (Exception ex) {
            return "Error creating the orden: " + ex.toString();
        }
        return "Orden creada con exito su numero de orden es: " + numero + "  ";
    }

    @RequestMapping(value = "/getOrdenes", method = RequestMethod.PUT)
    public List<OrdenDTO> obtenerOrdenes(@RequestBody OrdenVenta ordenVenta_cedula) {
        List<OrdenDTO> ordenDTOs = new ArrayList<OrdenDTO>();
        List<OrdenVenta> ordenVentas = new ArrayList<OrdenVenta>();
        int cedula = Integer.parseInt(ordenVenta_cedula.getNumeroDocCliente());
        ordenVentas = ordenDao.getAllOrdenes(cedula);

        
        for (OrdenVenta ordenVenta : ordenVentas) {
            OrdenDTO ordenDTO = new OrdenDTO();
            ordenDTO.setEstado(Util.numerToState(ordenVenta.getEstado()));
            ordenDTO.setFecha(ordenVenta.getFecha());
            ordenDTO.setCodigoOrden(ordenVenta.getCodigoOrden());
            
            if (ordenVenta.getEstado().equals("2") || ordenVenta.getEstado().equals("1")){
               ordenDTOs.add(ordenDTO);    
            }
            
        }

        return ordenDTOs;
    }

    @RequestMapping(value = "/deleteOrden", method = RequestMethod.DELETE)
    public String deleteOrden(@RequestBody OrdenVenta ordenVenta_cedula) throws IndexOutOfBoundsException {
        int codigoOrden = ordenVenta_cedula.getCodigoOrden();
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
            return "No existe una orden con el id referenciado";
        }
        return "Se elimino la orden correctamente";
    }

    @RequestMapping(value = "/cancelaOrden", method = RequestMethod.PUT)
    public String cancelaOrden(@RequestBody OrdenVenta ordenVenta_cedula) throws IndexOutOfBoundsException {
        int codigoOrden = ordenVenta_cedula.getCodigoOrden();
        try {
            OrdenVenta ordenVenta = new OrdenVenta();

            ordenVenta = ordenDao.getOdenVentaByCodigoOrden(codigoOrden);
            ordenVenta.setEstado("5");

            ordenDao.updateOrdenCancelar(ordenVenta);
        } catch (Exception e) {
            e.printStackTrace();
            return "No existe una orden con el id referenciado";
        }
        return "Se cancelo la orden correctamente";
    }

}
