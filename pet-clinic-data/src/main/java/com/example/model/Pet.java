package com.example.model;

import java.time.LocalDate;
import com.example.model.*;
public class Pet extends BaseEntity {
    private Owner owner;
    private PetType type;
    private LocalDate birthDate;

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getType() {
        return this.type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
