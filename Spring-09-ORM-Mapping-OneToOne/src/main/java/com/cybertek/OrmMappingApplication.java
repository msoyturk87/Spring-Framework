package com.cybertek;

import com.cybertek.entity.Department;
import com.cybertek.entity.Employee;
import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class OrmMappingApplication {



	public static void main(String[] args) {
		SpringApplication.run(OrmMappingApplication.class, args);
	}



	/*@PostConstruct
	public void dataInt(){


		Department d1=new Department("Clothing","Home");
		Department d2=new Department("Grocery","Home");
		Department d3=new Department("Decor","Home");
		Department d4=new Department("Furniture","Home");
		Department d5=new Department("Computers","Electronics");
		departmentRepository.save(d1);
		departmentRepository.save(d2);
		departmentRepository.save(d3);
		departmentRepository.save(d4);
		departmentRepository.save(d5);



	}*/


}
