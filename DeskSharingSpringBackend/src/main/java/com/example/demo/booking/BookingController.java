package com.example.demo.booking;

import com.example.demo.building.workplace.Workplace;
import com.example.demo.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/getAllBookings")
    public List<Booking> findAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/e1/findBookingsByUsername/{username}")
    public List<Booking> getBookingByUsername(@PathVariable String username) {
        return bookingService.getBookingByUsername(username);
    }

    @GetMapping("/getCurrentPhoneNumberofEmployees")
    public List <Employee> getAllPhoneNumbersofEmployees() {
        return bookingService.getAllPhoneNumbersofEmployees();
    }

    @GetMapping("/getCurrentTakenWorksplacesByOffice/{id}")
    public List<Workplace> getCurrentTakenWorkplacesByOffice(@PathVariable Long id) {
        return bookingService.getCurrentTakenWorkplacesByOffice(id);
    }

    @GetMapping("/e1/getBlockedBookingsByOffice/{id}")
        public List<Booking> getBlockedBookingsByOffice(@PathVariable Long id){
            return bookingService.getBlockedBookingsByOffice(id);
    }

    @PutMapping("/updateAkzeptiert/{id}")
    public Booking updateBookingbyIDSetStatusAkzeptiert(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusAkzeptiert(id);
    }

    @PutMapping("/e1/updateAbgelehnt/{id}")
    public Booking updateBookingbyIDSetStatusAbgelehnt(@PathVariable Long id){
        return bookingService.updateBookingbyIDSetStatusAbgelehnt(id);
    }

    @PutMapping("/leaveWorkspace/{eid}")
    public Booking leaveWorkspace(@PathVariable Long eid){
        return bookingService.leaveWorkspace(eid);
    }

    @PostMapping("/e1/saveBookingWithIDs/")
    public Booking saveBookingwithids(@RequestBody Booking booking){
        return bookingService.saveBookingwithids(booking);
    }
}
