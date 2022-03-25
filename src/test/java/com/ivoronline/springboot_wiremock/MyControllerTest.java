package com.ivoronline.springboot_wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.ivoronline.springboot_wiremock.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

  //PROPERTIES
  @Autowired PersonService personService;

  //============================================================
  // GET TEXT
  //============================================================
  @Test
  void getText() throws IOException {

    //MOCK SERVER
    WireMockServer wireMockServer = new WireMockServer(8085);
                   wireMockServer.start();
    configureFor("localhost", 8085);

    //MOCK ENDPOINT
    stubFor(get("/GetText?name=John").willReturn(
      aResponse().withBody("Hello John")
    ));

    //TEST SERVICE
    String result = personService.getText();
    assertEquals("Hello John", result);   System.out.println(result);

    //STOP MOCKED SERVER
    wireMockServer.stop();

  }

}


