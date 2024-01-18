package com.ashu.SpringBootCrud.controller;


import com.ashu.SpringBootCrud.exception.ResourceNotFoundException;
import com.ashu.SpringBootCrud.model.Employee;
import com.ashu.SpringBootCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {








    @Autowired // it is usefulfor passing dependencies and
    private EmployeeRepository employeeRepository;


    @GetMapping // this is mostly used to read the resources
    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    // create restapi employee

    @PostMapping   // used to create the resource              // here request body annotation convert json into java object
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);   // it helps to create employee
    }


    // GET employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("here Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);

    }


    // build update employee RESTAPI
    @PutMapping("{id}")    // used for update the resource so here we use putmapping :)

    public  ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);

    }
        // build delete employee RESTAPI
    @DeleteMapping("{id}")
        public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : "+id));

            employeeRepository.delete(employee);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);





    }

}
