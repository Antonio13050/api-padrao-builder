package com.padraobuilder.apipadraobuilder.repository;

import com.padraobuilder.apipadraobuilder.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByGuid(String guid);
}
