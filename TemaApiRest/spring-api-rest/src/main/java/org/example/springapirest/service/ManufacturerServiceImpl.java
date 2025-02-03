package org.example.springapirest.service;

import org.example.springapirest.model.Manufacturer;
import org.example.springapirest.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository repository;

    public ManufacturerServiceImpl(ManufacturerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Manufacturer> findAll() {

        return this.repository.findAll();
    }

    @Override
    public List<Manufacturer> findAllByYear(Integer year) {

        Objects.requireNonNull(year);
        return this.repository.findByYear(year);
    }

    @Override
    public Optional<Manufacturer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Manufacturer> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
