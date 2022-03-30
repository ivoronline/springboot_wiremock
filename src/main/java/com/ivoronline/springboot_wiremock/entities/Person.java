package com.ivoronline.springboot_wiremock.entities;

public class Person {

  //PROPERTIES
  public Integer id;
  public String  name;
  public Integer age;

  //CONSTRUCTORS
  public Person() {}                                          //When value is returned when calling Mock
  public Person(Integer id, String name, Integer age) {       //When defining Mock Server
    this.id   = id;
    this.name = name;
    this.age  = age;
  }

}
