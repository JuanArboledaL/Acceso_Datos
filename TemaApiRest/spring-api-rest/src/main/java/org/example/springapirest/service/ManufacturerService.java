package org.example.springapirest.service;

import org.example.springapirest.model.Manufacturer;

import java.util.List;
import java.util.Optional;



public interface ManufacturerService {

    //RETRIVE
    List<Manufacturer> findAll();
    List<Manufacturer> findAllByYear(Integer manufactureYear);
    Optional<Manufacturer> findById(Integer id);
    Optional<Manufacturer> findByName(String name);

    //create/update
    Manufacturer save(Manufacturer manufacturer);

    //DELETE
    void deleteById(Long id);
    void deleteAll();

    //Más logica de negocio
    //1. Coches fabricados
    //2.Beneficios obtenidos
}
