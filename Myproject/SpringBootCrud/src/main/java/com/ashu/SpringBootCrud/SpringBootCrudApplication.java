package com.ashu.SpringBootCrud;

import com.ashu.SpringBootCrud.model.Employee;
import com.ashu.SpringBootCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}


	@Autowired // it helps to passing dependencies at the same time .
	private EmployeeRepository employeeRepository ;

	@Override
	public void run(String... args) throws Exception {


		Employee employee=new Employee();
		employee.setFirstName("Ashutosh");
		employee.setLastName("Baghel");
		employee.setEmailId("Ashutosh.Baghel@coforge.com");
		employeeRepository.save(employee);


		Employee employee1=new Employee();
		employee.setFirstName("Aditya");
		employee.setLastName("Baghel");
		employee.setEmailId("baghelashu2001@gmail.com");
		employeeRepository.save(employee);








	}
}
