package com.skintrading.skinhub.api;

import org.springframework.web.bind.annotation.RestController;

import com.skintrading.skinhub.dao.PersonRepository;
import com.skintrading.skinhub.model.Person;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("service/person")
public class PersonService {
    
    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getPersonList(Model model) {

        List<Person> personList = (List<Person>)personRepository.findAll();

        if(personList == null || personList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(personList);
    }

    @GetMapping("/{id}")
    public Person getMethodName(@PathVariable Long id) {

        Optional<Person> result = personRepository.findById(id);

        if(result.isEmpty()){
            String msg = "Person("+ id + ") not found!";
            throw new RuntimeException(msg);
        }
        return result.get();
    }


    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {

        Person newPerson = personRepository.save(person);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(newPerson);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Person> putMethodName(@PathVariable Long id, @RequestBody Person updatedPerson) {

        Optional<Person> optPerson = personRepository.findById(id);

        if(optPerson.isPresent()){
            
            Person person = optPerson.get();
            
            person.setName(updatedPerson.getName());
            person.setEmail(updatedPerson.getEmail());
            person.setPassword(updatedPerson.getPassword());

            Person newPerson = personRepository.save(person);
            return ResponseEntity.ok(newPerson);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){

        Optional<Person> optPerson = personRepository.findById(id);
        if(optPerson.isPresent()){
            personRepository.delete(optPerson.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
