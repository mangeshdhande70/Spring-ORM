package in.ineuron.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.customeretrive.IRetrieve;
import in.ineuron.model.BrandName;
import in.ineuron.model.Product;
import in.ineuron.model.ProductType;
import in.ineuron.service.IProductService;

@Component
public class MyController {
	
	
	private Logger logger = LoggerFactory.getLogger(MyController.class);

	@Autowired
	private IProductService service;

	public void saveProduct() {
		
		

		Product product = new Product();

		product.setPrice(4650.0);
		product.setProductName("DOLL");
		product.setProductType(ProductType.TOYS);
		product.setQuantity(3);
		product.setBrandName(BrandName.LEVISE);

		boolean status = service.addProdcut(product);
		
		logger.info("Data Saved Successfully");

		System.out.println(status ? "save Successfully" : "Failed to save sorry");

	}

	public void fetchDataByType() {
		service.fetchProductByType(ProductType.CLOTH).forEach(System.out::println);
	}
	
	
	
	

	public void fetchProductByTypeAndProductPriceRange() {
		service.fetchProductByTypeAndProductPriceRange(ProductType.CLOTH, 1000.0, 1500.0).forEach(System.out::println);
	}
	
	
	

	public void fetchProductByTypeAndProductPriceRangeAndName() {

		service.fetchProductByTypeAndRangeAndName(ProductType.CLOTH, 1000.0, 2000.0, "T-Shirt")
				.forEach(System.out::println);

	}
	
	
	
	
	
	public void fetchProductByProductType() {
	
		List<IRetrieve> list = service.getDataByProductType(ProductType.FOOTWEAR, IRetrieve.class);
		
		list.forEach(product ->{
			System.out.println(product.getProductId());
		});
		
	}
	
	 public void fetchProductByPagination() {
		
		service.fetchDetailsByPagination(3);
		
	}

}
