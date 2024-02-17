package com.example.repository;

import com.example.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findOwnerByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
