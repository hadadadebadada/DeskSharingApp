package com.example.demo.ServiceTests;


import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceLayerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    EmployeeService employeeService;

    @BeforeEach
    void initUseCase() {
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void customer_exists_in_db_success() {
        Employee employee = new Employee();
        employee.setFirstname("test");
        employee.setId(1L);
/*
        System.out.println(employeeService.getEmployee(1L));

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);


        System.out.println(employeeRepository.findAll());
*/

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

    }
}
