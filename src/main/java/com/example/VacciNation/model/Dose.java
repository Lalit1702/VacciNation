package com.example.VacciNation.model;

import com.example.VacciNation.Enum.VaccineBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private VaccineBrand vaccineBrand;

    private boolean taken;

    private String serialNumber;

    @CreationTimestamp
    private Date dateOfVaccination;
}
