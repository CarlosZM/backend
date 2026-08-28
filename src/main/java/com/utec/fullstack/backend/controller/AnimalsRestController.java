package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.business.AnimalsService;
import com.utec.fullstack.backend.controller.request.Animals;
import com.utec.fullstack.backend.controller.request.CreateAnimalRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsRestController {

    @Autowired
    private AnimalsService animalsService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animals getAnimal(@PathVariable("id") Integer id) {
        return this.animalsService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Animals> getAnimals(@AuthenticationPrincipal UserDetails userDetails) {

        return this.animalsService.getByUser(userDetails.getUsername());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animals createProduct(@Valid @RequestBody CreateAnimalRequest animalRequest,
                                 @AuthenticationPrincipal UserDetails userDetails) {

        return this.animalsService.createAnimal(Animals.builder().name(animalRequest.getName()).user(userDetails.getUsername()).build());
    }

}