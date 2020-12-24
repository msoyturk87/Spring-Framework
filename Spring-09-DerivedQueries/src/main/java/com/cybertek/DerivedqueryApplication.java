package com.cybertek;

import com.cybertek.entity.Department;
import com.cybertek.entity.Region;
import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class DerivedqueryApplication {
	@Autowired
	RegionRepository regionRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueryApplication.class, args);
	}
	@PostConstruct
	public void testRegions(){
		System.out.println("-------------Regions start-------------");
		System.out.println(regionRepository.findByCountry("Canada"));
		System.out.println("-------------Regions end-------------");

		System.out.println("-------------Regions distinct start-------------");
		System.out.println(regionRepository.findDistinctByCountry("Canada"));
		System.out.println("-------------Regions end-------------");

		System.out.println("-------------Regions contains start-------------");
		System.out.println(regionRepository.findAllByCountryContains("United"));
		System.out.println("-------------Regions end-------------");

		System.out.println("-------------Regions order start-------------");
		System.out.println(regionRepository.findAllByCountryContainsOrderByCountry("United"));
		System.out.println("-------------Regions end-------------");

		System.out.println("-------------Regions top start-------------");
		System.out.println(regionRepository.findTop2ByCountry("Canada"));
		System.out.println("-------------Regions end-------------");

		System.out.println("-------------Department  start-------------");
		System.out.println(departmentRepository.findByDepartment("Furniture"));
		System.out.println("departmentRepository.findByDivision(\"Health\") = " + departmentRepository.findByDivision("Health"));
		System.out.println("departmentRepository.findDistinctTop3ByDivisionContains(\"Hea\") = " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
		System.out.println("-------------Department end-------------");
		System.out.println("-------------Employee start-------------");
		System.out.println("employeeRepository.findByEmail(\"bgillicuddyrp@adobe.com\") = " + employeeRepository.findByEmail("bgillicuddyrp@adobe.com"));
		employeeRepository.findByFirstNameAndLastNameOrEmail("Brandice", "Gillicuddy", "garonrn@java.com");
		System.out.println("employeeRepository.findByFirstNameIsNot(\"Brandice\") = " + employeeRepository.findByFirstNameIsNot("Brandice"));
		System.out.println("employeeRepository.findByEmailIsNull() = " + employeeRepository.findByEmailIsNull());
		System.out.println("-------------Employee end-------------");



	}
}

