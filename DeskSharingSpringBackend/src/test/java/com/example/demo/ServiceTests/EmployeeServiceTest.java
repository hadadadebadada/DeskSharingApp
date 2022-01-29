package com.example.demo.ServiceTests;


import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;



@RunWith(MockitoJUnitRunner.class)


public class EmployeeServiceTest {
    @Mock
    @Autowired
    private EmployeeRepository employeeRepository;
    EmployeeService employeeService;

    @BeforeEach
    public void setUp() {

        employeeService = new EmployeeService(employeeRepository);
    }



    @Test
    public void savedEmployee_Success() throws Exception{
        Employee employee1 = new Employee();

        employee1.setFirstname("Test");
        employee1.setLastname("Test");
        employee1.setEmail("test@test.de");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee1);

        Employee savedEmployee = employeeRepository.save(employee1);
        assertThat(savedEmployee.getFirstname()).isNotNull();

    }

    @Test
    public void Employee_exists_in_db_success() {
        Employee employee = new Employee();
        employeeService = new EmployeeService(employeeRepository);
        employee.setFirstname("Test");
        employee.setLastname("Test");
        employee.setEmail("test@test.de");


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        // providing knowledge
        when(employeeRepository.findAll()).thenReturn(employeeList);

      //  List<Employee> fetchedEmployees = employeeService.getAllEmployees();
      //  assertThat(fetchedEmployees.size()).isGreaterThan(0);
    }

    @Test
    public void findAll(){
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(12L, "Mohamad", "Halawi", "momo12", "mohamad.halawi@hs-osnabrueck.de", true, "123"));
        employeeList.add(new Employee(15L, "Artur", "Pfeifer", "artur312", "artur.pfeife@hs-osnabrueck.de", true, "565"));

        when(employeeRepository.findAll()).thenReturn(employeeList);

        //List<Employee> expectedList = employeeService.getAllEmployees();

//        assertEquals(2, expectedList.size());

    }

}


