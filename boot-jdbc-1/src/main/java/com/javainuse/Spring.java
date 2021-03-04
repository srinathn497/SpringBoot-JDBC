package com.javainuse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.javainuse.model.Student;
import com.javainuse.service.EmployeeService;

@ComponentScan("com.javainuse")
@SpringBootApplication
public class Spring {
	    
	/*
	 * @Autowired EmployeeService employeeService;
	 */
	  @Autowired
	  Student st;
	
	  	public static void main(String[] args) {
			
		System.out.println("spring main class");
		ConfigurableApplicationContext context = SpringApplication.run(Spring.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		Student st = context.getBean(Student.class);
		st.getStndname();
		System.out.println("spring main class+"+ st.toString() );
		employeeService.getAllEmployees();
		//List<Employee> employees = new ArrayList<>();
		//employeeService.getAllEmployees();
		//employeeService.getEmployeeById(emp1.getEmpId());

	}
}