package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.mysql.entity.Customer;
import in.ineuron.service.CustomerService;

@RestController
@RequestMapping(value = "/cust")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<Integer> addCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok().body(customerService.addCustomer(customer));
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id){
		return ResponseEntity.ok().body(customerService.getCustomer(id));
	}
}
