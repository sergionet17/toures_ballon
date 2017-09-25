package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	private static final Map<String, Country> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setReserva("123456ASGFG");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setNumeroVuelo(46704314);

		countries.put(spain.getReserva(), spain);

		Country poland = new Country();
		poland.setReserva("123456ASGFGwqwqw");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setNumeroVuelo(38186860);

		countries.put(poland.getReserva(), poland);

		Country uk = new Country();
		uk.setReserva("123456ASGFGsdssds343");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setNumeroVuelo(63705000);

		countries.put(uk.getReserva(), uk);
	}

	public Country findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}
}
