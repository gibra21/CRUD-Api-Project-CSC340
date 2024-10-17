package com.csc340.demo.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

    List<AnimalEntity> findBySpecies(String species);

    List<AnimalEntity> findByNameContaining(String name);

    @Query(value = "SELECT * PROM animals_db", nativeQuery = true)
    List<Entity> findAllAnimals();


}
