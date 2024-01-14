package com.example.bootstrap;

import com.example.model.Owner;
import com.example.model.PetType;
import com.example.model.Vet;
import com.example.services.OwnerService;
import com.example.services.PetTypeService;
import com.example.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService1) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService1;
    }
    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("dog");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Antoine");
        owner1.setLastName("Gordon");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Andrea");
        owner2.setLastName("Gordon");

        ownerService.save(owner2);
        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bob");
        vet1.setLastName("Duke");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("sam");
        vet2.setLastName("something");

        vetService.save(vet2);
        System.out.println("Loaded Vet");


    }
}
