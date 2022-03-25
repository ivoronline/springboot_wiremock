package com.ivoronline.springboot_wiremock.services;

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
      .create("http://localhost:8085")
      .get()
      .uri("/GetText?name=John")
      .retrieve()
      .bodyToMono(String.class)
      .block(Duration.ofSeconds(3));

    //DISPLAY PERSON
    return string;   //Hello John

  }

}


