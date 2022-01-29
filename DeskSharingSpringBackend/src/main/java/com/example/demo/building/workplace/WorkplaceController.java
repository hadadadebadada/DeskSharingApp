package com.example.demo.building.workplace;

import com.example.demo.booking.Booking;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workplace")
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class WorkplaceController {


    /*MÖGLICHE ERWEITERUNG*/


/*    @Autowired
    private WorkplaceService workplaceService;

    @GetMapping("/getAllWorkplaces")
    public List<Workplace> findAllWorkplaces(){
        return workplaceService.getAllWorkplaces();
    }

    @GetMapping("/getWorkplaceByID/{id}")
    public Workplace findAWorkplaceByID(@PathVariable Long id){
        return workplaceService.getWorkplace(id);
    }

    @PutMapping("/update")
    public Workplace updateWorkplace(@RequestBody Workplace workplace){
        return workplaceService.updateWorkplace(workplace);
    }

    @PostMapping("/saveWorkplace")
    public Workplace saveWorkplace(@RequestBody Workplace workplace){
        return workplaceService.saveWorkplace(workplace);
    }

    @PutMapping("/addBooking/{id}")
    public Workplace addBooking(@PathVariable Long id,@RequestBody Booking booking){
        return workplaceService.addBooking(id,booking);
    }*/

}
