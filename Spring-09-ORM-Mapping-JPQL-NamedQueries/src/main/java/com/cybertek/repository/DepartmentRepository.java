package com.cybertek.repository;

import com.cybertek.entity.Department;
import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {
    // display all departments in furniture
    List<Department> findByDepartment(String string);

    // display all departments in furniture
    List<Department> findByDivision(String string);

    // display all division in furniture
    List<Department> findByDivisionEquals(String string);

    // display all division endswith 'ics
    List<Department> findByDivisionEndsWith(String string);

    // display top 3 with division name includes "Hea,without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String string);





}
