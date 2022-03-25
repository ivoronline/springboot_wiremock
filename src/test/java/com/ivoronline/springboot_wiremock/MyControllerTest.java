package com.ivoronline.springboot_wiremock;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.ivoronline.springboot_wiremock.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WireMockTest(httpPort = 8085)
class PersonServiceTest {

  //PROPERTIES
  @Autowired PersonService personService;

  //============================================================
  // GET TEXT
  //============================================================
  @Test
  void getText() throws IOException {

    //MOCK ENDPOINT
    stubFor(get("/GetText?name=John").willReturn(
      aResponse().withBody("Hello John")
    ));

    //CALL SERVICE
    String result = personService.getText();

    //CHECK RESULT
    assertEquals("Hello John", result);   System.out.println(result);

  }

}


