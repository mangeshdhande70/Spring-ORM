package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.postgres.entity.Product;
import in.ineuron.postgressrepo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	public Integer addProduct(Product product) {
		return productRepo.save(product).getProductId();
	}
	
	public Product getProduct(Integer id) {
		return productRepo.findById(id).get();
	}


}
