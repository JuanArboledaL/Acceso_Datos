package org.example.springapirest.controller;

import org.example.springapirest.model.Manufacturer;
import org.example.springapirest.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class ManufacturerController {

    private ManufacturerService service;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.service = manufacturerService;
    }

    // Get http:// localhost:8080/api/manufacturers
    @GetMapping("/manufactuerers")
    public ResponseEntity<List<Manufacturer>> findAll(){

        List<Manufacturer> manufacturers = service.findAll();

        if(manufacturers.isEmpty()){

            return ResponseEntity.notFound().build();
        }

         return ResponseEntity.ok(manufacturers);
    }

    // Get http:// localhost:8080/api/manufacturers/year/{years}
    @GetMapping("/manufactuerers/year/{year}")
    public ResponseEntity<List<Manufacturer>> findAllByYear(@PathVariable Integer manufactureYear){

        List<Manufacturer> manufacturers = service.findAllByYear(manufactureYear);

        if(manufacturers.isEmpty()){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(manufacturers);
    }

    // Get http:// localhost:8080/api/manufacturers/{id}
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Integer id){

        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer){

        //Comprobaciones

        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer){

        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @DeleteMapping("/manufacturers/{identifier}")
    public ResponseEntity<Manufacturer> deleteById(@PathVariable ("identifier") Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
