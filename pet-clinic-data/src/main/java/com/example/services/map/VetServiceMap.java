package com.example.services.map;

import com.example.model.Speciality;
import com.example.model.Vet;
import com.example.services.SpecialityService;
import com.example.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;



@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpecial = specialityService.save(speciality);
                    speciality.setId(savedSpecial.getId());
                }
            });
        }
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);    }
}
