package com.free.client.soap;

import hello.wsdl.BuscarProductos;
import hello.wsdl.BuscarProductosResponse;
import hello.wsdl.ConsultarProducto;
import hello.wsdl.ConsultarProductoResponse;
import hello.wsdl.GetOrdenRequest;
import hello.wsdl.GetOrdenResponse;
import hello.wsdl.ObjectFactory;
import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class AviancaCliente extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(AviancaCliente.class);

    public GetOrdenResponse cancelFly(String ticker) {
        
        
        GetOrdenRequest request = new GetOrdenRequest();
        request.setNumeroOrden(ticker);

        log.info("Requesting quote for " + ticker);

        GetOrdenResponse response = (GetOrdenResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:28081/ws/american.wsdl",
                        request,
                        new SoapActionCallback("http://localhost:28081/ws/getCountry"));

            return response;
    }

}
