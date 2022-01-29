package com.example.demo.building.building;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository  extends JpaRepository<Building, Long> {
    Building findByDescription(String description);
}
