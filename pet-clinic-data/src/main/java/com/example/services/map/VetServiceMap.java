package com.example.services.map;

import com.example.model.Vet;
import com.example.services.CrudService;
import com.example.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;



@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{
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
