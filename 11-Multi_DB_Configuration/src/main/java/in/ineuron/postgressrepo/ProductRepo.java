package in.ineuron.postgressrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.postgres.entity.Product;


public interface ProductRepo extends JpaRepository<Product, Integer> {

}
