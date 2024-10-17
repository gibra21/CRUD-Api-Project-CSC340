package com.csc340.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/animals")

public class RestController {

    @Autowired
    private serviceforAnimals animalService;


    @GetMapping("/all")
    public List<AnimalEntity> getAllAnimals() {
        return animalService.getAllAnimals();
    }


    @GetMapping("/{animalId}")
    public AnimalEntity getAnimalById(@PathVariable int animalId) {

        return animalService.getAnimalById(animalId);
    }

    @PostMapping("/new")
    public void addNewAnimal(@RequestBody AnimalEntity animal){
         animalService.addAnimal(animal);
    }

    @PutMapping("/update/{animalId}")
    public void updateAnimal(@PathVariable int animalId, @RequestBody AnimalEntity animal) {
         animalService.updateAnimal(animalId, animal);
    }

    @DeleteMapping("/delete/{animalId}")
    public void deleteAnimal(@PathVariable int animalId) {
         animalService.deleteAnimalById(animalId);
    }

    @GetMapping("/species/{species}")
    public List<AnimalEntity> getAnimalsBySpecies(@RequestParam String species) {
        return animalService.getAnimalsBySpecies(species);
    }
    @GetMapping("/search")
    public List<AnimalEntity> searchAnimalsByName(@RequestParam String name) {
        return animalService.searchAnimalByName(name);
    }
}
