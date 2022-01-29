package com.example.demo.building.office;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Office")
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class OfficeController {

/*MÖGLICHE ERWEITERUNG*/


/*    @Autowired
    private OfficeService officeService;

    @GetMapping("/getAllOffices")
    public List<Office> findAllOffices(){
        return officeService.getAllOffice();
    }

    @PostMapping("/saveOffice/{id}")
    public Office addOffice(@RequestBody Office office){
        return officeService.saveOffice(office);
    }
    */

}
