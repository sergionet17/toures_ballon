package com.free.client.soap;

import hello.wsdl.BuscarProductos;
import hello.wsdl.BuscarProductosResponse;
import hello.wsdl.ConsultarProducto;
import hello.wsdl.ConsultarProductoResponse;
import hello.wsdl.GetOrdenRequest;
import hello.wsdl.GetOrdenResponse;
import hello.wsdl.ObjectFactory;
import hello.wsdl.RankingProductos;
import hello.wsdl.RankingProductosResponse;
import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class RankingCliente extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(AviancaCliente.class);

    public RankingProductosResponse ranking(String ticker) {
        
        ObjectFactory factory = new ObjectFactory();
        RankingProductos request = new RankingProductos();
        String fechaI = "2015/12/12";
        String fechaF  = "2017/12/12";
        JAXBElement<String> fechaInicial = factory.createRankingProductosFchInicial(fechaI);
        JAXBElement<String> fechaFinal = factory.createRankingProductosFchInicial(fechaF);
        request.setFchFinal(fechaInicial);
        request.setFchInicial(fechaFinal);

        log.info("Requesting quote for " + ticker);

        RankingProductosResponse response = (RankingProductosResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://25.83.72.20/WcfProductos/WcfProductos.svc",
                        request,
                        new SoapActionCallback("http://tempuri.org/IWcfProductos/RankingProductos"));

            return response;
    }

}
