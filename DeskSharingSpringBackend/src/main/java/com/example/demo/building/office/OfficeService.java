package com.example.demo.building.office;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Service("api/v1/offices")
public class OfficeService {


    /*MÖGLICHE ERWEITERUNG*/

/*    @Autowired // new
    private final OfficeRepository officeRepository;

    @GetMapping
    public List<Office> getAllOffice(){
        return officeRepository.findAll();
    }

    @PostMapping
    public Office saveOffice(Office office){ //funktioniert auch als list
        return officeRepository.save(office);
    }

    @GetMapping
    public Office getOffice(long id){
        return officeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Office getOfficeByDescription(String desciption){
        return officeRepository.findByDescription(desciption);
    }

    public String deleteOffice(long id){
        officeRepository.deleteById(id);
        return "office deleted";
    }

    public Office updateOffice(Office office){
        Office office1  = officeRepository.findById(office.getId()).orElse(null);
        office1.setDescription(office.getDescription());
        return officeRepository.save(office1);
    }*/
}
