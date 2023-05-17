package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "produce_price")
	private Double price;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "brand_name")
	@Enumerated(EnumType.STRING)
	private BrandName brandName;
}
