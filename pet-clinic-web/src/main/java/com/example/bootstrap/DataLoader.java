package com.example.bootstrap;

import com.example.model.*;
import com.example.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }
    @Override
    public void run(String... args) throws Exception {
        log.info("hello world, its a me lombok");
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("dog");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Antoine");
        owner1.setLastName("Gordon");
        owner1.setAddress("123 sw 123 ave");
        owner1.setCity("Miami");
        owner1.setTelephone("3051234567");

        Pet antPet = new Pet();
        antPet.setPetType(savedDogType);
        antPet.setOwner(owner1);
        antPet.setName("Sunny Bunny");
        antPet.setBirthDate(LocalDate.of(2010, 7, 6));
        owner1.getPets().add(antPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Andrea");
        owner2.setLastName("Gordon");
        owner2.setAddress("123 sw 123 ave");
        owner2.setCity("Miami");
        owner2.setTelephone("3051234567");

        Pet andreaPet = new Pet();
        andreaPet.setPetType(savedCatType);
        andreaPet.setOwner(owner1);
        andreaPet.setName("Sunny the Cat");
        andreaPet.setBirthDate(LocalDate.of(2010, 7, 6));
        owner2.getPets().add(andreaPet);
        ownerService.save(owner2);
        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bob");
        vet1.setLastName("Duke");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("sam");
        vet2.setLastName("something");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
        System.out.println("Loaded Vet");

        Visit visit = new Visit();
        visit.setPet(andreaPet);
        visit.setDate(LocalDate.now());
        visit.setDescription("sunny bunny eating dirt");

        visitService.save(visit);

    }
}
