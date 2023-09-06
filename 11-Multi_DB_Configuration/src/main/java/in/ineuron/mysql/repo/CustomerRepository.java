package in.ineuron.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.mysql.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
