package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        RestTemplate restTemplate = new RestTemplate();

        OrdenVenta ordenVenta = restTemplate.getForObject(
                "http://localhost:8090/getOrdenVenta/1", OrdenVenta.class);
        log.info(ordenVenta.toString());
        String estado = ordenVenta.getEstado();

        if (estado != "Cerrado") {
            final String uri = "http://localhost:8090/setOrdenVenta/1";

            Map<String, String> params = new HashMap<String, String>();
            params.put("estado", "CANCELADO");

            OrdenVenta updatedEmployee = new OrdenVenta("Cancelado");

            RestTemplate restTemplate_set = new RestTemplate();
            restTemplate.put(uri, updatedEmployee, params);
        }
        return response;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            OrdenVenta ordenVenta = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", OrdenVenta.class);
            log.info(ordenVenta.toString());
        };
    }
}
