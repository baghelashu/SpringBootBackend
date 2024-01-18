package com.ashu.SpringBootCrud.repository;

import com.ashu.SpringBootCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // helps to get all crud databases methods



}
