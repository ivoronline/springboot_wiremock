package com.ivoronline.springboot_wiremock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.ivoronline.springboot_wiremock.entities.Person;
import com.ivoronline.springboot_wiremock.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WireMockTest(httpPort = 8080)
class PersonServiceTest {

  //PROPERTIES
  @Autowired PersonService personService;

  //============================================================
  // GET TEXT
  //============================================================
  @Test
  void getText() throws IOException {

    //MOCK ENDPOINT
    stubFor(get("/GetText?name=John")
      .willReturn(aResponse()
        .withHeader("Content-Type", "text/plain")
        .withBody("Hello John")
      )
    );

    //CALL SERVICE
    String result = personService.getText();

    //DISPLAY RESULT
    System.out.println("getText()");
    System.out.println(result);

    //CHECK RESULT
    assertEquals("Hello John", result);

  }

  //============================================================
  // GET PERSON
  //============================================================
  @Test
  void getPerson() throws IOException {

    //CREATE PERSON TO BE RETURNED
    Person person     = new Person(1, "John", 20);
    String personJSON = new ObjectMapper().writeValueAsString(person);

    //MOCK ENDPOINT
    stubFor(get("/GetPerson")
      .willReturn(aResponse()
        .withHeader("Content-Type", "application/json")
        .withBody(personJSON)
        //.withBody("{\"id\":1,\"name\":\"John\",\"age\":20}")
      )
    );

    //CALL SERVICE
    Person personResult = personService.getPerson();

    //DISPLAY RESULT: 1 John 20
    String personResultJSON = new ObjectMapper().writeValueAsString(person);
    System.out.println("getPerson()");
    System.out.println(personResultJSON);

    //CHECK RESULT
    assertEquals("John", personResult.name);

  }

  //============================================================
  // GET PERSONS
  //============================================================
  @Test
  void getPersons() throws IOException {

    //CREATE PERSONS TO BE RETURNED
    Person   person1     = new Person(1, "John", 20);
    Person   person2     = new Person(2, "Bill", 30);
    Person[] persons     = {person1, person2};
    String   personsJSON = new ObjectMapper().writeValueAsString(persons);

    //MOCK ENDPOINT
    stubFor(get("/GetPersons")
      .willReturn(aResponse()
        .withHeader("Content-Type", "application/json")
        .withBody(personsJSON)
        //.withBody("[\n" +
        //  "  {\"id\":1,\"name\":\"John\",\"age\":30},\n" +
        //  "  {\"id\":2,\"name\":\"Bill\",\"age\":40}\n" +
        //  "]\n")
      )
    );

    //CALL SERVICE
    Person[] personsResult = personService.getPersons();

    //DISPLAY RESULT: [2 John 30, 3 Bill 40]
    System.out.println("getPersons()");
    for (Person personResult : personsResult) {
      String personResultJSON = new ObjectMapper().writeValueAsString(personResult);
      System.out.println(personResultJSON);
    }

    //CHECK RESULT
    assertEquals("Bill", persons[1].name);

  }

}


