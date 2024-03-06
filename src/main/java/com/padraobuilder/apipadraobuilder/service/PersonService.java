package com.padraobuilder.apipadraobuilder.service;

import com.padraobuilder.apipadraobuilder.exceptions.PersonNotFoundException;
import com.padraobuilder.apipadraobuilder.model.Person;
import com.padraobuilder.apipadraobuilder.model.builders.PersonBuilder;
import com.padraobuilder.apipadraobuilder.model.transport.PersonDTO;
import com.padraobuilder.apipadraobuilder.model.transport.operations.CreatePersonForm;
import com.padraobuilder.apipadraobuilder.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public PersonDTO create(CreatePersonForm form){
        String passwordEncoded = this.passwordEncoder.encode(form.password());
        Person person = PersonBuilder.builder()
                .withName(form.name())
                .withPhone(form.phone())
                .withEmail(form.email())
                .withPassword(passwordEncoded)
                .build();
        this.personRepository.save(person);
        return new PersonDTO(person);
    }

    public PersonDTO findByGuid(String guid) throws PersonNotFoundException {
        return this.personRepository.findByGuid(guid)
                .map(PersonDTO::new)
                .orElseThrow(() -> new PersonNotFoundException("Usuário não encontrado"));
    }
}
