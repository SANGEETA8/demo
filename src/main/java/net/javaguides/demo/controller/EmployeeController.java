package net.javaguides.demo.controller;

import net.javaguides.demo.exception.ResourceNotfound;
import net.javaguides.demo.model.Employee;
import net.javaguides.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee()
    {
    return employeeRepository.findAll();

    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //build get employee by id rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee= employeeRepository.findById(id).orElseThrow(()->new ResourceNotfound("Employee not Exists with id:"+id));
        return ResponseEntity.ok(employee);
    }
    //build update employee Rest API
    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable  long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotfound("Employee not exists"+id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailID(employeeDetails.getEmailID());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee Rest API
    @DeleteMapping("{id}")
        public  ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotfound("Exception not exist with Id"+id));
        employeeRepository.delete(employee);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

}

