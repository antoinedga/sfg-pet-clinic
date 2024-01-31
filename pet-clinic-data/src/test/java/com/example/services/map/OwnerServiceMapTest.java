package com.example.services.map;

import com.example.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final long ownerId = 1l;
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName("Gordon").build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        long id = 2l;
        Owner owner2 = Owner.builder().id(id).lastName("Gordon").build();
        Owner saved = ownerServiceMap.save(owner2);
        assertEquals(id, saved.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1l);
        assertEquals(1, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("Gordon");
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }
}