package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);
    Employee findByUsername(String username);
}
