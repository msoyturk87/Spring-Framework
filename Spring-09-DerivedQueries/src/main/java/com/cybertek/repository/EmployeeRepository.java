package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // display all employees with email
    List<Employee> findByEmail(String email);

    // display all employees with first name "" and lastname "" also show all employees with a email adress
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employess where lastname startwith ""
    List<Employee> findByLastNameStartsWith(String lastname);

    //Display all employess where lastname startwith ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employess where lastname startwith ""
    List<Employee> findBySalaryAfter(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate start,LocalDate end);

    /// Display all employees greater and equalto  In order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    /// Display all distinct top3 salary less than
    List<Employee> findDistinctTop3BySalaryIsLessThan(Integer salary);

    // Display all employees that do not have email adress
    List<Employee>findByEmailIsNull();














}
