package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit extends BaseEntity{

    private LocalDate date;
    private String description;
    @ManyToOne
    @JoinColumn( name ="pet_id")
    private Pet pet;
}
