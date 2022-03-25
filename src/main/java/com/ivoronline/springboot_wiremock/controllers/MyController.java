package com.ivoronline.springboot_wiremock.controllers;

import com.ivoronline.springboot_wiremock.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired PersonService personService;

  //============================================================
  // HELLO
  //============================================================
  @RequestMapping("GetText")
  String getText() {
    return personService.getText();
  }

}
