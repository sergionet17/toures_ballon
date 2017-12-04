package com.free.client.soap;

import com.free.client.soap.QuoteClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class QuoteConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("hello.wsdl");
		return marshaller;
	}

	@Bean
	public QuoteClient quoteClient(Jaxb2Marshaller marshaller) {
		QuoteClient client = new QuoteClient();
		client.setDefaultUri("http://25.83.213.228:7101/PICATouresBalon/ProxyWcfProductos?wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
