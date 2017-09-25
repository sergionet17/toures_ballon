/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import netgloo.models.Producto;
import netgloo.models.ProductoDao;
import netgloo.models.ProductosCampania;
import netgloo.models.ProductosCampaniaDao;
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
public class ProductosCampaniaController {

    @Autowired
    private ProductosCampaniaDao productoCampaniaDao;

    /*?id=1&espectaculo=SERGIO&fecha=12/12/17&idCiudad=12&precio=123456*/
    @RequestMapping(value = "/createProductoCampania", method = RequestMethod.POST)
    @ResponseBody
    public String createCampana(@RequestParam("idProducto") int id,
            @RequestParam("idCampania") int idCampania) {
        try {
            ProductosCampania productoCampania = new ProductosCampania
        (id, idCampania);
            productoCampaniaDao.create(productoCampania);
        } catch (Exception ex) {
            return "Error creating the orden: " + ex.toString();
        }
        return "Orden succesfully created!";
    }

    // Metodo para obtner la campaña segun el email
    //localhost:8080/user/12
    @RequestMapping(value = "/productoCampania/{codigoProducto}", method = RequestMethod.GET)
    public ProductosCampania getProducto(@PathVariable("codigoProducto") int codigoProducto) throws IndexOutOfBoundsException {
        ProductosCampania producto = new ProductosCampania();
        try {
            List<ProductosCampania> listProducto = new ArrayList<ProductosCampania>();
            listProducto = productoCampaniaDao.getByCodigoProduto(codigoProducto);
            producto = listProducto.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }

}
