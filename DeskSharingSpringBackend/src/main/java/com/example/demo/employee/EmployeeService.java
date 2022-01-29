package com.example.demo.employee;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Service("api/v1/employees")
public class EmployeeService {

    @Autowired // new
    private final EmployeeRepository employeeRepository;


//    @GetMapping()
//    public List<Employee> getAllEmployees(){
//        return employeeRepository.findAll();
//    }
//
//    @PostMapping
//    public Employee saveEmployee(Employee employee){ //funktioniert auch als list
//        return employeeRepository.save(employee);
//    }
//
//    @GetMapping
//    public Employee getEmployee(Long id){
//        return employeeRepository.findById(id).orElse(null);
//    }
//
//    @GetMapping
//    public Employee getEmployeeByEmail(String email){
//        return employeeRepository.findByEmail(email);
//    }
//
//    public String deleteEmployee(Long id){
//        employeeRepository.deleteById(id);
//        return "employee deleted";
//    }
    @GetMapping
    public Employee getEmployeeByUsername(String username){
        return employeeRepository.findByUsername(username);
    }

//    @PutMapping
//    public Employee updateEmployee(Employee employee){
//        Employee employee1  = employeeRepository.findById(employee.getId()).orElse(null);
//        employee1.setEmail(employee.getEmail());
//        employee1.setFirstname(employee.getFirstname());
//        employee1.setLastname(employee.getLastname());
//        return employeeRepository.save(employee1);
//    }

}
