package com.example.demo.building.workplace;


import com.example.demo.booking.Booking;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;

@AllArgsConstructor
@Service("api/v1/workplaces")
public class WorkplaceService {


    /*MÖGLICHE ERWEITERUNG*/

/*    @Autowired // new
    private final WorkplaceRepository workplaceRepository;

    @GetMapping
    public List<Workplace> getAllWorkplaces(){
        return workplaceRepository.findAll();
    }

    @PostMapping
    public Workplace saveWorkplace(Workplace workplace){ //funktioniert auch als list
        return workplaceRepository.save(workplace);
    }

    @GetMapping
    public Workplace getWorkplace(long id){
        return workplaceRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Workplace getWorkplaceByPhone(String phone){
        return workplaceRepository.findByphone(phone);
    }

    public String deleteWorkplace(long id){
        workplaceRepository.deleteById(id);
        return "workplace deleted";
    }

    @PutMapping
    public Workplace updateWorkplace(Workplace workplace){
        Workplace workplace1  = workplaceRepository.findById(workplace.getId()).orElse(null);
        workplace1.setPhone(workplace.getPhone());
        //workplace1.setBookings(workplace.getBookings());
        return workplaceRepository.save(workplace1);
    }

    @PutMapping
    public Workplace addBooking(Long id, Booking booking){
        Workplace workplace1  = workplaceRepository.findById(id).orElse(null);
        //List<Booking> bookings=workplace1.getBookings();
        //bookings.add(booking);
        //workplace1.setBookings(bookings);
        return workplaceRepository.save(workplace1);
    }*/

}
