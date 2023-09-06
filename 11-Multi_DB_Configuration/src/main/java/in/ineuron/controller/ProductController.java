package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.postgres.entity.Product;
import in.ineuron.service.ProductService;

@RestController
@RequestMapping(value = "/prod")
public class ProductController {
	

	@Autowired
	private ProductService productService;
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<Integer> addProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(productService.addProduct(product));
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Product> getCustomer(@PathVariable Integer id){
		return ResponseEntity.ok().body(productService.getProduct(id));
	}
	

}
