package com.example.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.model.*;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Pet extends BaseEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    private LocalDate birthDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
