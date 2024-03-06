package com.padraobuilder.apipadraobuilder.model.builders;

import com.padraobuilder.apipadraobuilder.model.Person;

public class PersonBuilder {

    private String name;
    private String email;
    private String phone;
    private String password;

    private PersonBuilder(){
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }

    public PersonBuilder withName(String name){
        this.name = name;
        return this;
    }

    public PersonBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public PersonBuilder withPhone(String phone){
        this.phone = phone;
        return this;
    }

    public PersonBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public Person build(){
        return new Person(this.name, this.email, this.phone, this.password);
    }

}
