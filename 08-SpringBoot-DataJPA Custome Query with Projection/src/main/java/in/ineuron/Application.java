package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.vaccineservice.ICoronaVaccineMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

//		service.fetchVaccineByCompany("ccc").forEach(System.out::println);
		
		
		List<String> countries = new ArrayList<>();
		
		
		service.searchVaccineByCountriesAndPriceRange(countries, 300.0, 400.0);
		
	
		((ConfigurableApplicationContext) factory).close();
	}

}
