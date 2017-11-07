package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


import io.spring.guides.gs_producing_web_service.Currency;
import io.spring.guides.gs_producing_web_service.Orden;
import java.util.ArrayList;
import java.util.List;
import netgloo.models.OrdenDao;
import netgloo.models.OrdenVenta;
import netgloo.models.ProductoOrdenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	
        
        @Autowired
        private OrdenDao ordenDao;
        
        public Orden cancelaOrdenAvianca(String codigoOrden){            
            int codigo = Integer.parseInt(codigoOrden);
            Orden orden = new Orden();
            List<ProductoOrdenes> productoOrdeneses = new ArrayList<ProductoOrdenes>();
            productoOrdeneses = ordenDao.
                        getProductoByCodigoOrden(codigo);
            orden.setComentarios("No se encontraron vuelos avianca con "
                    + "el numero de orden");
            for (ProductoOrdenes productoOrdenes: productoOrdeneses){
                
                if (productoOrdenes.getCodigoProveedorTrans()== 2){
                    productoOrdenes.setNumeroRerserveTrans(0);
                    productoOrdenes.setCodigoProveedorTrans(0);
                    ordenDao.updateProductoOrden(productoOrdenes);
                    orden.setComentarios("Vuelo Avianca cancelado");
                }
            }
            
            orden.setNumeroOrden(codigoOrden);           
            return orden;
        }
}
