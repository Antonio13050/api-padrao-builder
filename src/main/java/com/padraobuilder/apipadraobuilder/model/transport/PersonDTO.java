package com.padraobuilder.apipadraobuilder.model.transport;

import com.padraobuilder.apipadraobuilder.model.Person;

public record PersonDTO(String guid,
                        String name,
                        String email,
                        String phone) {

    public PersonDTO(Person person){
        this(person.getGuid(), person.getName(), person.getEmail(), person.getPhone());
    }
}
