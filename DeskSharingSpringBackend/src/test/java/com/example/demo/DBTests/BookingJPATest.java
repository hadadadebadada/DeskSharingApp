package com.example.demo.DBTests;

import com.example.demo.booking.Booking;
import com.example.demo.booking.BookingRepository;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookingJPATest {

    @Autowired
    BookingRepository bookingRepository;
    EmployeeRepository employeeRepository;

    Booking booking;

    @BeforeEach
    void setUp()  {

//        Date date1 = new Date();
//        Date date2 = new Date();
//        booking = new Booking(5L,date1 ,date2, "akzeptiert");
////        booking = new Booking(6L,date1 ,date2, "gebucht");
//        bookingRepository.save(booking);
    }


    @Test
    void getAcceptedBookingsByEmployee() throws Exception{
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking book: bookings){
            if(book.getStatus().equals("akzeptiert") ){
                if(book.getEmployee()== null){

                }else{
                    Employee e = book.getEmployee();
                    System.out.println("Die Buchungen fuer Mitarbeiter " + e.getFirstname()+ " sind folgende:" + book.toString());
                }

            }

        }

    }

    @Test
    void getPendingBookingsByEmployee() throws Exception{
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking book: bookings){
            if(book.getStatus().equals("schwebend") ){
                if(book.getEmployee()== null){

                }else{
                    Employee e = book.getEmployee();
                    System.out.println("Die Buchungen fuer Mitarbeiter " + e.getFirstname()+ " sind folgende:" + book.toString());
                }

            }

        }

    }
}



