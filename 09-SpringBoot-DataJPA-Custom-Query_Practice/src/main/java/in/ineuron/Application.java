package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.controller.MyController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		
		MyController controller = context.getBean(MyController.class);
		
	    controller.saveProduct();
//		controller.fetchDataByType();
//		controller.fetchProductByTypeAndProductPriceRange();
		
//		controller.fetchProductByTypeAndProductPriceRangeAndName();
		
//		controller.fetchProductByProductType();
		
//		controller.fetchProductByPagination();

		
	}

}
