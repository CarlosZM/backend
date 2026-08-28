package com.utec.fullstack.backend.business;

import com.utec.fullstack.backend.controller.request.Animals;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalsService {

    private List<Animals> animals = new ArrayList<>() {{
        add(
                Animals.builder()
                        .id(1)
                        .name("Perro")
                        .user("juan")
                        .createdAt(LocalDateTime.now())
                        .build());
        add(
                Animals.builder()
                        .id(2)
                        .name("Gato")
                        .user("pablo")
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }};

    public Animals createAnimal(Animals newAnimal) {
        newAnimal.setCreatedAt(LocalDateTime.now());
        newAnimal.setId(this.animals.size() + 1);
        this.animals.add(newAnimal);

        return newAnimal;
    }

    public List<Animals> getAll() {
        return this.animals;
    }

    public List<Animals> getByUser(String username) {
        List<Animals> newAnimals = new ArrayList<>();

        for (Animals animal : this.animals) {
            if (animal.getUser().equals(username)) {
                newAnimals.add(animal);
            }
        }

        /**
         return this.animals.stream()
         .filter(a->a.getUser().equals(userDetails.getUsername()))
         .collect(Collectors.toList());
         */
        return newAnimals;
    }

    public Animals getById(Integer id) {
        return this.animals.get(id - 1);
    }
}
