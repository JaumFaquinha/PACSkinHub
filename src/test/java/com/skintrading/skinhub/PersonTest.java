package com.skintrading.skinhub;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skintrading.skinhub.model.Person;
import com.skintrading.skinhub.dao.PersonRepository;

@SpringBootTest
public class PersonTest
{
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSave(){

        Person person = new Person();
        person.setName("João");
        person.setEmail("joaoteste@email.com.br");
        person.setPassword("senha");        
        personRepository.save(person);
        assertNotNull(person.getId());

        person = new Person();
        person.setName("Vinicius");
        person.setEmail("viniciusteste@email.com");
        person.setPassword("senha123");
        personRepository.save(person);
        assertNotNull(person.getId());

    }

}
