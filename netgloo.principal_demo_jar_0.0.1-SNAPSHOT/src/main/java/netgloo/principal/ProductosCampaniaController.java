/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import netgloo.models.Productos;
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
    
    @Autowired
    private ProductoDao productoDao;

    /*?id=1&espectaculo=SERGIO&fecha=12/12/17&idCiudad=12&precio=123456*/
    @RequestMapping(value = "/createProductoCampania", method = RequestMethod.POST)
    @ResponseBody
    public String createCampana(@RequestParam("idCampania") int id) {
        try {
            ProductosCampania productoCampania = new ProductosCampania
        (id);
            productoCampaniaDao.create(productoCampania);
        } catch (Exception ex) {
            return "Error creating the orden: " + ex.toString();
        }
        return "Orden succesfully created!";
    }

    // Metodo para obtner la campaña segun el email
    //localhost:8080/user/12
    @RequestMapping(value = "/productoCampania/{codigoCampania}", method = RequestMethod.GET)
    public List<Productos> getProducto(@PathVariable("codigoCampania") int codigoCampania) throws IndexOutOfBoundsException {        
        List<ProductosCampania> listProductoCampania = new ArrayList<ProductosCampania>();
        List<Productos> listFinal = new ArrayList<Productos>();
        try {            
            listProductoCampania = productoCampaniaDao.getByCodigoProduto(codigoCampania);
            List<Integer> listInt = new ArrayList<Integer>();
            
            for (ProductosCampania productosCampania: listProductoCampania){
               listInt.add(productosCampania.getIdProducto());
            }                                    
            for (Integer var: listInt){
               Productos producto = new Productos();
               List<Productos> list = new ArrayList<Productos>();               
               list = productoDao.getByCodigoProduto(var);
               
               producto = list.get(0);
               if(producto != null){
               listFinal.add(producto);
               }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFinal;
    }

}
