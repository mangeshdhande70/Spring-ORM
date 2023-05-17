package in.ineuron.service;

import java.util.List;

import in.ineuron.customeretrive.IView;
import in.ineuron.model.Product;
import in.ineuron.model.ProductType;

public interface IProductService {
	
	public boolean addProdcut(Product product);
	
	public List<Product> fetchProductByType(ProductType productType);
	
	public List<Product> fetchProductByTypeAndProductPriceRange(ProductType productType , Double minPrice , Double maxPrice);

	public List<Product> fetchProductByTypeAndRangeAndName(ProductType productType , Double minPrice, Double maxPrice,String productName);
	
	
	public <T extends IView> List<T> getDataByProductType(ProductType productType, Class<T> clazz);
	
	public void fetchDetailsByPagination(int pageSize);
	

	
}
