package com.elkinandrea.repasoendpoint.enpointae.controllers;

import com.elkinandrea.repasoendpoint.enpointae.data.dto.PersonDto;
import com.elkinandrea.repasoendpoint.enpointae.data.payload.PersonForm;
import com.elkinandrea.repasoendpoint.enpointae.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    //inyectando el servicio de persona
    @Autowired
    private PersonService personService;

    @PostMapping("/save")
    public PersonDto createPerson(@RequestBody PersonForm dataPerson){
        return this.personService.savePerson(dataPerson);
    }

    @GetMapping("/all")
    public List<PersonDto> getAll(){
        return this.personService.getAll();
    }

    @PutMapping("/update/{id}")
    public PersonDto updatePerson(@PathVariable("id") Long id, @RequestBody PersonForm in){
        return this.personService.update(id, in);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        return this.personService.delete(id);
    }


}
