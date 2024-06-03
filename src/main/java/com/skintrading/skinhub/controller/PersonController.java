package com.skintrading.skinhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skintrading.skinhub.dao.PersonRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    
//Retorna todos
    // @GetMapping("/")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    
    //Retorna a
}
