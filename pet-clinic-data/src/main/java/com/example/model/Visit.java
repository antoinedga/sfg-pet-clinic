package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Visit extends BaseEntity{

    private LocalDate date;
    private String description;
    @ManyToOne
    @JoinColumn( name ="pet_id")
    private Pet pet;
}
