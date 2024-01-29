package com.example.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Speciality extends BaseEntity{
    private String description;
}
