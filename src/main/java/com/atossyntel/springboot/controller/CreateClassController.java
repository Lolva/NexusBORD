package com.atossyntel.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateClassController {
 @RequestMapping(value = "/CreateClass", method = RequestMethod.GET)
  public String init(Model model) {
    return "CreateClass";
  }
}