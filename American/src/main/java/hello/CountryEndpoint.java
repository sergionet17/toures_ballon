package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import io.spring.guides.gs_producing_web_service.GetOrdenRequest;
import io.spring.guides.gs_producing_web_service.GetOrdenResponse;
import java.util.ArrayList;
import java.util.List;
import netgloo.models.OrdenDao;
import netgloo.models.OrdenVenta;
import org.springframework.ws.soap.addressing.server.annotation.Action;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository countryRepository;
        
        //@Autowired
        //private OrdenDao ordenDao;


	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
        
        //http://localhost:28080/ws/countries.wsdl
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrdenRequest")
	@ResponsePayload
        @Action("http://fer2.klab/notify/ServiceRequest")
	public GetOrdenResponse getCountry(@RequestPayload GetOrdenRequest request) {
		GetOrdenResponse response = new GetOrdenResponse();                
		response.setOrden
                        (countryRepository.cancelaOrdenAvianca(request.getNumeroOrden()));
		return response;
	}
}
