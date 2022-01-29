package com.example.demo.booking;

import com.example.demo.building.workplace.Workplace;
import com.example.demo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface BookingRepository  extends JpaRepository<Booking, Long> {

    // Find Statemants nach Variablen
List<Booking> findByStatus (String status);
List<Booking> findByEmployee (Employee employee);
List <Booking> findByWorkplace (Workplace workplace);
}
