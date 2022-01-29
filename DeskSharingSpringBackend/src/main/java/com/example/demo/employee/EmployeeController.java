package com.example.demo.employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    /*API GET*/
//    @GetMapping("/getAllEmployees")
//    public List<Employee> findAllEmployees(){
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/findEmployeeById/{id}")
//    public Employee getEmployeeById(@PathVariable Long id){
//        return employeeService.getEmployee(id);
//
//    }

    @GetMapping("/e1/findEmployeeByUsername/{username}")
        public Employee getEmployeeByName(@PathVariable String username){
        return employeeService.getEmployeeByUsername(username);

    }

    @GetMapping("/findEmployeeByUsername/{username}")
        public Employee getEmployeeByNameAdmin(@PathVariable String username){
        return employeeService.getEmployeeByUsername(username);

    }
//
//    @GetMapping("/findEmployeeByEmail/{email}")
//    public Employee getEmployeeByEmail(@PathVariable String email){
//        return employeeService.getEmployeeByEmail(email);
//    }
//
//    /*API POST*/
//    @PostMapping("/saveEmployee/{id}")
//    public Employee addEmployee(@RequestBody Employee employee){
//        return employeeService.saveEmployee(employee);
//
//    }
//
//    /*API PUT*/
//    @PutMapping("/update")
//    public Employee updateEmployee(@RequestBody Employee employee){
//        return employeeService.updateEmployee(employee);
//    }
//
//    /*API DELETE*/
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteEmployee(@PathVariable Long id){
//        return employeeService.deleteEmployee(id);
//    }







}































































































































































































