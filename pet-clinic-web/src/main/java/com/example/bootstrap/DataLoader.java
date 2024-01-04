package com.example.bootstrap;

import com.example.model.Owner;
import com.example.model.Vet;
import com.example.services.OwnerService;
import com.example.services.VetService;
import com.example.services.map.OwnerServiceMap;
import com.example.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    public DataLoader() {
        vetService = new VetServiceMap();
        ownerService = new OwnerServiceMap();
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Antoine");
        owner1.setLastName("Gordon");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Andrea");
        owner2.setLastName("Gordon");

        ownerService.save(owner2);
        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Bob");
        vet1.setLastName("Duke");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Bob");
        vet2.setLastName("Duke");

        vetService.save(vet2);
        System.out.println("Loaded Vet");
    }
}
