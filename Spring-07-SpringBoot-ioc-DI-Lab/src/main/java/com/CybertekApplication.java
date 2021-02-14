package com;

import com.calculator.Calculator;
import com.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CybertekApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext container=SpringApplication.run(CybertekApplication.class, args);

		Calculator calculator=container.getBean("calculator",Calculator.class);

		System.out.println(calculator.getTotalCarpetCost(City.ARLINGTON));



	}


}
