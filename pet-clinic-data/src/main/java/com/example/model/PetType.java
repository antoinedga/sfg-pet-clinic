package com.example.model;

import jakarta.persistence.Entity;
import lombok.*;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetType extends BaseEntity{
    private String name;
    @Override
    public String toString() {
        return name;
    }
}
