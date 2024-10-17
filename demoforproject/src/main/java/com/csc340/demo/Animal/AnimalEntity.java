package com.csc340.demo.Animal;

import jakarta.persistence.*;

@Entity
@Table(name = "animal_db")

public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalID;

    @Column(nullable = false)
    private String name;

    private String scientificName;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String habitat;

    private String description;

    public AnimalEntity(int animalID, String name, String scientificName, String species, String habitat, String description) {
        this.animalID = animalID;
        this.name = name;
        this.scientificName = scientificName;
        this.species = species;
        this.habitat = habitat;
        this.description = description;

    }

    public AnimalEntity(String name, String scientificName, String species, String habitat, String description) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.description = description;


    }

    public AnimalEntity(){

    }

    public int getAnimalID() {
        return animalID;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDescription() {
        return description;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public void setName(String name) {this.name = name;}

    public void setScientificName(String scientificName) {this.scientificName = scientificName;}

    public void setSpecies(String species) {this.species = species;}

    public void setHabitat(String habitat) {this.habitat = habitat;}

    public void setDescription(String description) {this.description = description;}
}
