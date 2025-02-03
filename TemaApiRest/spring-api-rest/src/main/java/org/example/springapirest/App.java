package org.example.springapirest;

import org.example.springapirest.model.Manufacturer;
import org.example.springapirest.repository.ManufacturerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(App.class, args);
        var repository = context.getBean(ManufacturerRepository.class);
        repository.save(new Manufacturer(null,"manufacturer1",1000,1990));

    }

}
