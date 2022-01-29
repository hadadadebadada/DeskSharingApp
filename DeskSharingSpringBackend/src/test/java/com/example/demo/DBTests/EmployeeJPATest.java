package com.example.demo.DBTests;


import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJPATest {

    @Autowired
    EmployeeRepository employeeRepository;
    Employee employee;




    @BeforeEach
    void setUp() {

        employee = new Employee(12L, "Mohamad", "Halawi", "momo12", "mohamad.halawi@hs-osnabrueck.de", true, "123");
        employee = new Employee(15L, "Artur", "Pfeifer", "artur312", "artur.pfeife@hs-osnabrueck.de", true, "565");
        employeeRepository.save(employee);
//    }
    }

    @Test
    void getEmployeesTest() throws Exception {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(employees.get(1).getEmail());
        System.out.println(employees.get(2).getEmail());
        System.out.println(employees.get(3).getEmail());

    }

    @Test
    void getEmployeeByUsername() throws Exception{

        Employee e = employeeRepository.findByUsername("artur312");
        System.out.println(e.toString());
    }

    @Test
    void getEmployeeByEmail() throws Exception{

        Employee e = employeeRepository.findByEmail("artur.pfeifer@hs-osnabrueck.de");
        System.out.println(e.toString());
    }

    @Test
    void addEmployeeTest() throws Exception{

        Employee e = new Employee(12L, "Florian", "Funke", "momo12", "Florian.funke@hs-osnabrueck.de", true, "123");
        employeeRepository.save(e);
        List<Employee> employees = employeeRepository.findAll();
        for (Employee emp : employees) {
            System.out.println(emp.toString());
        }
    }
}
