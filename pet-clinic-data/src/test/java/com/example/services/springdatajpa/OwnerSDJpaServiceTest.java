package com.example.services.springdatajpa;

import com.example.model.Owner;
import com.example.repository.OwnerRepository;
import com.example.repository.PetRepository;
import com.example.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName("alavarez").build();
        ownerSDJpaService.save(owner);
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(Collections.singleton(owner));
        assertEquals(1, ownerSDJpaService.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(owner));
        assertEquals(1L, ownerSDJpaService.findById(1L).getId());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        ownerSDJpaService.save(owner);
        verify(ownerRepository, atLeastOnce()).save(any());
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
        doNothing().when(ownerRepository).deleteById(any());
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(1L).lastName("gordon").build();
        when(ownerRepository.findOwnerByLastName(any())).thenReturn(owner);
        Owner result = ownerSDJpaService.findByLastName("gordon");

        assertEquals(1L, result.getId());
    }
}