package in.ineuron.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef= "entityManagerFactory",
	transactionManagerRef = "transactionManager",
	basePackages = "in.ineuron.mysql.repo")
public class MySQLDBConfiguration {
	
	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER_NAME; 
	
	@Value("${spring.datasource.url}")
	private  String URL; 
	
	@Value("${spring.datasource.username}")
	private  String USERNAME; 
	
	@Value("${spring.datasource.password}")
	private  String PASSWORD; 
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private  String DIALECT; 
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private  String DDL_AUTO; 
	
	@Value("${spring.jpa.show-sql}")
	private  String SHOW_SQL;
	
	@Value("${spring.jpa.properties.hibernate.packagesToScan}")
	private String PACKAGE_TO_SCAN;
	

	//DataSource Object for MySQl
	@Bean
	@Primary
	public  DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
	    dataSource.setUrl(URL);
	    dataSource.setUsername(USERNAME);
	    dataSource.setPassword(PASSWORD);
		return dataSource;
	}

	//EntityManagerFactory
	@Bean(name = "entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", DDL_AUTO);
		properties.put("hibernate.dialect", DIALECT);
		properties.put("hibernate.show-sql", SHOW_SQL);
		properties.put("hibernate.packagesToScan",PACKAGE_TO_SCAN);
		
		bean.setJpaPropertyMap(properties);
		bean.setPackagesToScan(PACKAGE_TO_SCAN);
		
		return bean;
		
		
	}
	
	
	// Transaction Management
	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager db1TransactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	}
