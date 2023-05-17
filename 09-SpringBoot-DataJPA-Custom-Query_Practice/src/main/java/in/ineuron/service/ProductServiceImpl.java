package in.ineuron.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.ineuron.customeretrive.IView;
import in.ineuron.dao.IProductDao;
import in.ineuron.model.Product;
import in.ineuron.model.ProductType;

@Service
public class ProductServiceImpl implements IProductService {

	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private IProductDao productDao;

	@Override
	public boolean addProdcut(Product product) {

		Product product2 = null;

		try {
			product2 = productDao.save(product);
			logger.info(product2 +" Data Saved in Database");
		} catch (HibernateException e) {
			logger.error("An error occurred: {}", e.getMessage());
			logger.error("Exception stack trace: ", e);
			// Any additional context information
			logger.error("Context information: {}");
		} catch (Exception e) {
			logger.error("An error occurred: {}", e.getMessage());
			logger.error("Exception stack trace: ", e);
		}

		return product2 != null ? true : false;
	}

	@Override
	public List<Product> fetchProductByType(ProductType productType) {

		List<Product> list = productDao.findByProductType(productType);

		return list;
	}

	@Override
	public List<Product> fetchProductByTypeAndProductPriceRange(ProductType productType, Double minPrice,
			Double maxPrice) {

		return productDao.findByProductTypeAndPriceBetween(productType, minPrice, maxPrice);
	}

	@Override
	public List<Product> fetchProductByTypeAndRangeAndName(ProductType productType, Double minPrice, Double maxPrice,
			String productName) {

		return productDao.findByProductTypeAndPriceBetweenAndProductName(productType, minPrice, maxPrice, productName);
	}

	@Override
	public <T extends IView> List<T> getDataByProductType(ProductType productType, Class<T> clazz) {
		return productDao.findByProductType(productType, clazz);
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {

		// total record count
		long count = productDao.count();// total = 7

		// deciding pagesCount
		long pagesCount = count / pageSize;// pagesCount = 7/3 = 2
		pagesCount = count % pageSize == 0 ? pagesCount : ++pagesCount; // pagesCount = 3

		for (int i = 0; i < pagesCount; i++) {
			// loop running from 0,1,2
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Product> page = productDao.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("-------------------" + (i + 1) + " of :: " + page.getTotalPages());
		}

	}

}
