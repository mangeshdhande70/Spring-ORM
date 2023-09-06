package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.mysql.entity.Customer;
import in.ineuron.mysql.repo.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public Integer addCustomer(Customer customer) {
		return customerRepository.save(customer).getCustId();
	}
	
	public Customer getCustomer(Integer id) {
		return customerRepository.findById(id).get();
	}

}
