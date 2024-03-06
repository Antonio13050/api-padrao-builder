package com.padraobuilder.apipadraobuilder.controller;

import com.padraobuilder.apipadraobuilder.exceptions.PersonNotFoundException;
import com.padraobuilder.apipadraobuilder.model.transport.PersonDTO;
import com.padraobuilder.apipadraobuilder.model.transport.operations.CreatePersonForm;
import com.padraobuilder.apipadraobuilder.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody CreatePersonForm body, UriComponentsBuilder uriComponentsBuilder){
        PersonDTO response = this.personService.create(body);
        return ResponseEntity.created(uriComponentsBuilder.path("person/{id}").buildAndExpand(response.guid()).toUri()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findByGuid(@PathVariable("id") String guid) throws PersonNotFoundException {
        PersonDTO response = this.personService.findByGuid(guid);
        return ResponseEntity.ok(response);
    }

}
