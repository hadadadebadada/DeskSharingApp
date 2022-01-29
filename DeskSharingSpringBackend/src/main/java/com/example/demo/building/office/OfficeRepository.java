package com.example.demo.building.office;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {

    Office findByDescription(String description);
}
