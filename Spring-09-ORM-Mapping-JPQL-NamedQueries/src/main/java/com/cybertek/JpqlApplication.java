package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {
	@Autowired
	RegionRepository regionRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args);
	}
	@PostConstruct
	public void testNamedQueries(){
		System.out.println("----------Employee----------");
		System.out.println("employeeRepository.getEmployeeDetail() = " + employeeRepository.getEmployeeDetail());
		System.out.println("employeeRepository.getEmployeeSalary() = " + employeeRepository.getEmployeeSalary());
		System.out.println("employeeRepository.getEmployeeSalary() = " + employeeRepository.getEmployeeSalary("Trail"));

	}

}
