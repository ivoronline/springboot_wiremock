package com.ivoronline.springboot_wiremock.controllers;

import com.ivoronline.springboot_wiremock.entities.Person;
import com.ivoronline.springboot_wiremock.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired PersonService personService;

  //============================================================
  // GET TEXT
  //============================================================
  @RequestMapping("GetText")
  String getText() {
    return personService.getText();
  }

  //============================================================
  // GET PERSON
  //============================================================
  @RequestMapping("GetPerson")
  Person getPerson() {
    return personService.getPerson();
  }

  //============================================================
  // GET PERSONS
  //============================================================
  @RequestMapping("GetPersons")
  Person[] getPersons() {
    return personService.getPersons();
  }

}
