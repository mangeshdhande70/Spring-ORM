package in.ineuron.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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
	entityManagerFactoryRef= "secondEntityManagerFactory",
	transactionManagerRef = "secondTransactionManager",
	basePackages = "in.ineuron.postgressrepo")
public class PostgressDBConfiguration {
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Environment environment;
	
//	@Value("${second.datasource.driver-class-name}")
//	private String DRIVER_NAME; 
	
	@Value("${second.jpa.properties.hibernate.dialect}")
	private  String DIALECT; 
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private  String DDL_AUTO; 
	
	@Value("${spring.jpa.show-sql}")
	private  String SHOW_SQL;
	
	@Value("${second.jpa.properties.hibernate.packagesToScan}")
	private String PACKAGE_TO_SCAN;
	
	    //DataSource Object for PostGress
		@Bean
		public  DataSource db2Configuration() {
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
//			LOGGER.info("********* " +DRIVER_NAME +" *********");
			dataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
		    dataSource.setUrl(environment.getProperty("second.datasource.url"));
		    dataSource.setUsername(environment.getProperty("second.datasource.username"));
		    dataSource.setPassword(environment.getProperty("second.datasource.password"));
			return dataSource;
		}

		//EntityManagerFactory
		@Bean(name = "secondEntityManagerFactory")
		public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory() {
			
			LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
			bean.setDataSource(db2Configuration());
			
			JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
			bean.setJpaVendorAdapter(jpaVendorAdapter);
			
			HashMap<String, Object> properties = new HashMap<>();
			properties.put("hibernate.hbm2ddl.auto", DDL_AUTO);
			properties.put("hibernate.dialect", DIALECT);
//			properties.put("hibernate.show-sql", SHOW_SQL);
			
			bean.setJpaPropertyMap(properties);
			bean.setPackagesToScan(PACKAGE_TO_SCAN);
			
			return bean;
			
			
		}
		
		
		// Transaction Management
		@Bean(name = "secondTransactionManager")
		public PlatformTransactionManager db2TransactionManager(@Qualifier("secondEntityManagerFactory") EntityManagerFactory emf) {
			return new JpaTransactionManager(emf);
		}

}
