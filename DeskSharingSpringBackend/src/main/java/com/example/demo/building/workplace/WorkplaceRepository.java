package com.example.demo.building.workplace;


import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceRepository extends JpaRepository<Workplace, Long> {
    Workplace findByphone(String phone);
}
