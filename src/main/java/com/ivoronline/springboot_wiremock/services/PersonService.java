package com.ivoronline.springboot_wiremock.services;

import com.ivoronline.springboot_wiremock.entities.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Component
public class PersonService {

  //===============================================================
  // GET TEXT
  //===============================================================
  public String getText() {

    //GET PERSON FROM SERVER
    String string = WebClient
      .create("http://localhost:8080")
      .get()
      .uri("/GetText?name=John")
      .retrieve()
      .bodyToMono(String.class)
      .block(Duration.ofSeconds(3));

    //RETURN TEXT
    return string;   //Hello John

  }

  //===============================================================
  // GET PERSON
  //===============================================================
  public Person getPerson() {

    //GET PERSON FROM SERVER
    Person person = WebClient.create("http://localhost:8080")
      .get()
      .uri("/GetPerson")
      .retrieve()
      .bodyToMono(Person.class)
      .block(Duration.ofSeconds(3));

    //RETURN PERSON
    return person;

  }

  //===============================================================
  // GET PERSONS
  //===============================================================
  public Person[] getPersons() {

    //GET PERSON FROM SERVER
    Person[] persons = WebClient.create("http://localhost:8080")
      .get()
      .uri("/GetPersons")
      .retrieve()
      .bodyToMono(Person[].class)
      .block(Duration.ofSeconds(3));

    //RETURN PERSONS
    return persons;

  }

}


