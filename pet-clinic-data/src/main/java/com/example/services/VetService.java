package com.example.services;

import com.example.model.Owner;
import com.example.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);

}
