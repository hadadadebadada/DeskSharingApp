package com.example.demo.building.building;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Service("api/v1/buildings")
public class BuildingService {

    /*MÖGLICHE ERWEITERUNG*/


/*    @Autowired // new
    private final BuildingRepository buildingRepository;

    @GetMapping
    public List<Building> getAllBuilding(){
        return buildingRepository.findAll();
    }

    @PostMapping
    public Building saveBuilding(Building building){ //funktioniert auch als list
        return buildingRepository.save(building);
    }

    @GetMapping
    public Building getBuilding(long id){
        return buildingRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Building getBuildingByEmail(String description){
        return buildingRepository.findByDescription(description);
    }

    public String deleteBuilding(long id){
        buildingRepository.deleteById(id);
        return "Building deleted";
    }

    public Building updateBuilding(Building building){
        Building building1  = buildingRepository.findById(building.getId()).orElse(null);
        building1.setDescription(building.getDescription());
        return buildingRepository.save(building1);
    }*/
}

