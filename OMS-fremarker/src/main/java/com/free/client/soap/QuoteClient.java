package com.free.client.soap;

import hello.wsdl.BuscarProductos;
import hello.wsdl.BuscarProductosResponse;
import hello.wsdl.ConsultarProducto;
import hello.wsdl.ConsultarProductoResponse;
import hello.wsdl.ObjectFactory;
import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class QuoteClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(QuoteClient.class);

    public BuscarProductosResponse getProducto(String ticker,String nombre) {
        if (ticker == null){
            ticker = "";
        }
        if (nombre == null){
            nombre = "";
        }
        
                
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> jaxbElement = objectFactory.createBuscarProductosCodigo(ticker);
        JAXBElement<String> jaxbElement_nombre = objectFactory.createBuscarProductosCodigo(nombre);
        
        
        
        BuscarProductos request = new BuscarProductos();
        request.setCodigo(jaxbElement);
        request.setNombre(jaxbElement_nombre);

        log.info("Requesting quote for " + ticker);

        BuscarProductosResponse response = (BuscarProductosResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://25.83.213.228:7101/PICATouresBalon/ProxyWcfProductos?wsdl",
                        request,
                        new SoapActionCallback("http://tempuri.org/IWcfProductos/BuscarProductos"));

            return response;
    }

}
