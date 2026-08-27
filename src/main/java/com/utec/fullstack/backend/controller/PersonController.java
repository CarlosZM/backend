package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.controller.request.*;
import com.utec.fullstack.backend.controller.response.GetAgeResponse;
import com.utec.fullstack.backend.controller.response.GetAgeResponseV3;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonMapping mapper;

    private List<Person> persons = new ArrayList<>() {{
        add(Person.builder()
                .id(1)
                .name("Carlos")
                .birthDay(LocalDate.of(1994, 4, 14))
                .dni("76638765")
                .build());
        add(Person.builder()
                .id(2)
                .name("Juan")
                .birthDay(LocalDate.of(1998, 5, 14))
                .dni("9886843")
                .build());
    }};

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersons() {
        return this.persons;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersons(@PathVariable("id") Integer id) {
        return this.persons.get(id - 1);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@Valid @RequestBody CreatePersonRequest request) {

        Person person = this.mapper.convert(request);

        person.setId(this.persons.size() + 1);

        this.persons.add(person);

        return person;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person updatePerson(@PathVariable("id") Integer id, @RequestBody UpdatePersonRequest personRequest) {
        Person oldProductWithNewInfo = this.mapper.convert(personRequest);
        Person oldProduct = this.persons.get(id - 1);

        Person updatePerson = this.mapper.copyFrom(oldProduct, oldProductWithNewInfo);

        this.persons.set(id - 1, updatePerson);

        return updatePerson;
    }

    @GetMapping("{id}/age")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAge(@PathVariable("id") Integer id) {
        Person currentPerson = this.persons.get(id - 1);

        //return 2026 - currentPerson.getBirthDay().getYear(); opcion valida
        //return Period.between(currentPerson.getBirthDay(), LocalDate.now()).getYears(); //mejor opcion
        return Map.of("age", Period.between(currentPerson.getBirthDay(), LocalDate.now()).getYears());
    }

    @GetMapping("{id}/age-v2")
    @ResponseStatus(HttpStatus.OK)
    public GetAgeResponse getAgeV2(@PathVariable("id") Integer id) {
        Person currentPerson = this.persons.get(id - 1);

        return GetAgeResponse.builder()
                .age(Period.between(currentPerson.getBirthDay(), LocalDate.now()).getYears())
                .build();
    }

    @GetMapping("{id}/age-v3")
    @ResponseStatus(HttpStatus.OK)
    public GetAgeResponseV3 getAgeV3(@PathVariable("id") Integer id) {
        Person currentPerson = this.persons.get(id - 1);

        return new GetAgeResponseV3(Period.between(currentPerson.getBirthDay(), LocalDate.now()).getYears());
    }
}
