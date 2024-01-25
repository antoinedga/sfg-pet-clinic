package com.example.services.springdatajpa;

import com.example.model.Vet;
import com.example.repository.VetRepository;
import com.example.services.SpecialityService;
import com.example.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    private final SpecialityService specialityService;
    private final VetRepository vetRepository;

    public VetSDJpaService(SpecialityService specialityService, VetRepository vetRepository) {
        this.specialityService = specialityService;
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetRepository.findAll().forEach(vetSet::add);
        return vetSet;
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> optionalVet = vetRepository.findById(id);
        if (optionalVet.isPresent()) {
            return optionalVet.get();
        }
        return null;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
