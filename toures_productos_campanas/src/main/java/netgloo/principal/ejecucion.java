package netgloo.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories("netgloo.models")
@ComponentScan({"netgloo.principal,netgloo.models"})
@EntityScan("netgloo.models")
@SpringBootApplication
public class ejecucion {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplicationCustomer.class, args);
	}
        
}