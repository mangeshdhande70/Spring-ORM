package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.customeretrive.IView;
import in.ineuron.model.Product;
import in.ineuron.model.ProductType;

@Repository
public interface IProductDao extends JpaRepository<Product, Long> {

	public List<Product> findByProductType(ProductType productType);
	
	public List<Product> findByProductTypeAndPriceBetween(ProductType productType , Double minPrice, Double maxPrice);
	
	
	public List<Product> findByProductTypeAndPriceGreaterThanEqual(ProductType productType , Double minPrice);
	
	
	public List<Product> findByProductTypeAndPriceBetweenAndProductName(ProductType productType , Double minPrice, Double maxPrice,String productName);
	
//    List<Product> findByPrice(Double price);
	
	public <T extends IView> List<T> findByProductType(ProductType productType , Class<T> class1);
	
	
	
}
