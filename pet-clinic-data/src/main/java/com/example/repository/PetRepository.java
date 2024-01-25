package com.example.repository;

import com.example.model.Pet;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Id> {
}
