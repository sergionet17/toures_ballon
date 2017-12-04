
package hello;

import hello.wsdl.GetQuoteResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
                
	}

	@Bean
	String metodoInicial(QuoteClient quoteClient) {
			String ticker = "ORCL";

		
			GetQuoteResponse response = quoteClient.getQuote(ticker);
			 System.err.println(response.getGetQuoteResult());
                         
                        return response.getGetQuoteResult();
	}

}
