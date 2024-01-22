package com.example.model;

import jakarta.persistence.Entity;
import lombok.*;



@Entity
@Data
public class PetType extends BaseEntity{
    private String name;

}
