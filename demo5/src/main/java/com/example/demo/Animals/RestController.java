package com.example.demo.Animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animals")

public class RestController {

    @Autowired
    private serviceforAnimals animalService;


    @GetMapping("/all")
    public String getAllAnimals(Model model) {

        model.addAttribute("animalList", animalService.getAllAnimals());
        return "animal-list";
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

