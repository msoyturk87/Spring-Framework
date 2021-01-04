package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e FROM  Employee e WHERE e.email='dtrail8@tamu.edu'")
    Employee getEmployeeDetail();
    // name can be different but to understand what to do we are following naming convention
    // Employee should be  Entity name but we can change it from entity
    // @Entity(name="Employess")  -- We can change Entity name but it is unnecessary

    @Query("SELECT e.salary FROM  Employee e WHERE e.lastName='Trail' ")
    Integer getEmployeeSalary();

    //Dynamic way to write NamedQueries
    // 1-- POSITIONAL PARAMETERS
    //single bind parameter
    @Query("SELECT e.salary FROM  Employee e WHERE e.lastName=?1 ")
    Integer getEmployeeSalary(String lastname);

    @Query("SELECT e.salary FROM  Employee e WHERE e.email=?1 ")
    Employee getEmployeeDetail(String email);

    //multiple bind parameter
    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email,int salary);

    // 2-- NAMED PARAMETERS
    //single named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //multiple named parameters
    @Query("SELECT e FROM Employee e WHERE e.firstName=:name OR e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name,@Param("salary") int salary);


    //Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeBySalaryNotEqual(int salary);

    //Like / Contains / StartsWith / Ends With
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String patter);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //Greater Than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1,int salary2);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeByEmailIsNotNull();


    //Sort Salary in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //Sort Salary in descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> getEmployeeBySalaryOrderByDesc();

    //Native Query
    // with native queries we will use table name
    @Query(value = "SELECT * FROM employees WHERE salary = ?1",nativeQuery = true )
    List<Employee> readEmployeeBySalary(int salary);


    // Named Query with Modifying
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email ='admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") Integer id);

    // Native Query with Modifying
    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email='admin@email.com' WHERE id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);

    //Named Query
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);
}
