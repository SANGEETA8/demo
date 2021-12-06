package net.javaguides.demo;

import net.javaguides.demo.model.Employee;
import net.javaguides.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Ramesh");
		
		employee.setLastName("Bhagat");
		employee.setEmailID("Ramesh@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("john");
		employee1.setLastName("sue");
		employee1.setEmailID("Jsue@gmail.com");
		employeeRepository.save(employee1);

	}
}
