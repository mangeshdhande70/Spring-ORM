package in.ineuron;

import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.controller.MyController;

@SpringBootApplication
public class Application {

	public static void main(String[] args)  {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
	  MyController myController = context.getBean(MyController.class);
		
		
	  try {
		myController.fetchById();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	  myController.registermarriageSeeker();
		
	}

}
