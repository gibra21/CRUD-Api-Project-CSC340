package com.csc340.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class serviceforAnimals {

    @Autowired
    private AnimalRepository animalRepository;


    public List<AnimalEntity> getAllAnimals() {

        return animalRepository.findAll();
    }


    public AnimalEntity getAnimalById(int animalId) {

        return animalRepository.findById(animalId).orElse(null);
    }

    public AnimalEntity addAnimal(AnimalEntity animal) {
        return animalRepository.save(animal);
    }



    public void updateAnimal(int animalId, AnimalEntity newAnimal) {
        AnimalEntity existing = getAnimalById(animalId);
        if (existing != null) {
            existing.setName(newAnimal.getName());
            existing.setScientificName(newAnimal.getScientificName());
            existing.setSpecies(newAnimal.getSpecies());
            existing.setHabitat(newAnimal.getHabitat());
            existing.setDescription(newAnimal.getDescription());
            animalRepository.save(existing);
        }



    }


    public void deleteAnimalById(int id) {

         animalRepository.deleteById(id);


    }
    public List<AnimalEntity> getAnimalsBySpecies(String species) {

        return animalRepository.findBySpecies(species);
    }

    public List<AnimalEntity> searchAnimalByName(String name) {
        return animalRepository.findByNameContaining(name);
    }


}