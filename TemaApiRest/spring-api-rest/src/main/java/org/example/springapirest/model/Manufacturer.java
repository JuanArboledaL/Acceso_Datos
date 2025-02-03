package org.example.springapirest.model;


import jakarta.persistence.*;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(unique = true)
    private String name;

    @Column(name = "num_employees")
    private Integer  numEmployees;

    private Integer manufactureYear;

    public Manufacturer() {
    }

    public Manufacturer(Long id, String name, Integer numEmployees, Integer manufactureYear) {
        this.id = id;
        this.name = name;
        this.numEmployees = numEmployees;
        this.manufactureYear = manufactureYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(Integer numEmployees) {
        this.numEmployees = numEmployees;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer year) {
        this.manufactureYear = year;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numEmployees=" + numEmployees +
                ", year=" + manufactureYear +
                '}';
    }
}
