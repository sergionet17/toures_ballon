package com.free.client.soap;

import com.free.client.soap.QuoteClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class AviancaConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("hello.wsdl");
		return marshaller;
	}

	@Bean
	public AviancaCliente aviancaClient(Jaxb2Marshaller marshaller) {
		AviancaCliente client = new AviancaCliente();
		client.setDefaultUri("http://localhost:28081/ws/american.wsdl");

                client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
