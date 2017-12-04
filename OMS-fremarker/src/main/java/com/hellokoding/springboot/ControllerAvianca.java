/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.springboot;

import com.free.client.soap.AviancaCliente;
import com.free.client.soap.AviancaConfiguration;
import com.free.client.soap.QuoteClient;
import com.free.client.soap.QuoteConfiguration;
import hello.wsdl.BuscarProductosResponse;
import hello.wsdl.GetOrdenResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.free.pojo.AviancaCancelar;
import spring.free.pojo.Producto;

/**
 *
 * @author sergio
 */
@Controller
public class ControllerAvianca {
    
    String mensaje;
    
    @RequestMapping("/hola")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/cancelarOrdenAvianca", method = RequestMethod.POST)
    public String getProducto(@ModelAttribute("cProducto") Producto producto) {
        AviancaConfiguration configuration = new AviancaConfiguration();
        Jaxb2Marshaller jaxb2Marshaller = configuration.marshaller();
        AviancaCliente client = configuration.aviancaClient(jaxb2Marshaller);

        GetOrdenResponse getOrdenResponse = client.cancelFly(producto.getCodigo());
       mensaje = getOrdenResponse.getOrden().getComentarios();
        return "redirect:/cancelarAviancaNotificacion";
    }

     @RequestMapping(value = "/cancelarAvianca", method = RequestMethod.GET)
    public String getProductoLista(@ModelAttribute("model") AviancaCancelar model) {        
        return "cancelarAvianca";
    }
    
     @RequestMapping(value = "/cancelarAviancaNotificacion", method = RequestMethod.GET)
    public String getProductoLista(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("mensaje", mensaje);
        return "cancelarAviancaNotificacion";
    }
    /*
    @RequestMapping(value = "/cancelarAvianca", method = RequestMethod.GET)
    public String getProductoLista(@ModelAttribute("model") AviancaCancelar model) {
        
        return "consultarProductoResult";
    }*/
}
