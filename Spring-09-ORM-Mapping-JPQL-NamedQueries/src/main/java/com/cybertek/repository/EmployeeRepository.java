package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e FROM  Employee e WHERE e.email='dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM  Employee e WHERE e.lastName='Trail' ")
    Integer getEmployeeSalary();

    //Dynamic way to write NamedQueries
    // 1--BINDING
    //single bind parameter
    @Query("SELECT e.salary FROM  Employee e WHERE e.lastName=?1 ")
    Integer getEmployeeSalary(String lastname);

    @Query("SELECT e.salary FROM  Employee e WHERE e.email=?1 ")
    Employee getEmployeeDetail(String email);

    //multiple bind parameter
    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email,int salary);

    // 2--NAMED PARAMETERS
    //single named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //multiple named parameters
    @Query("SELECT e FROM Employee e WHERE e.firstName=:name OR e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name,@Param("salary") int salary);



}
