package com.example.VacciNation.repository;

import com.example.VacciNation.model.Dose;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {

}
