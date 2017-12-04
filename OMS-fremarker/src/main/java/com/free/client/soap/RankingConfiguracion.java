package com.free.client.soap;

import com.free.client.soap.QuoteClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class RankingConfiguracion {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("hello.wsdl");
		return marshaller;
	}

	@Bean
	public RankingCliente quoteClient(Jaxb2Marshaller marshaller) {
		RankingCliente client = new RankingCliente();
		client.setDefaultUri("http://25.83.72.20:50812/WcfProductos.svc");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
