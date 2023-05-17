package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.model.Employee;
import in.ineuron.service.EmployeeServiceImpl;
import in.ineuron.service.IEmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		IEmployeeService iEmployeeService = context.getBean(EmployeeServiceImpl.class);
		
		Employee employee = new Employee();
		
		employee.setName("Mangesh");
		employee.setSalary(10000.9);
	
		
		iEmployeeService.save(employee);
	 
	}

}
