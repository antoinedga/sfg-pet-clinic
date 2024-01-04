package com.example.bootstrap;

import com.example.services.OwnerService;
import com.example.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

//    private final OwnerService ownerService;
//    private final VetService vetService;
//    public DataLoader() {
//        ownerService = new OwnerServiceMap()
//    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("booty");
    }
}
