package com.digi.trainers.hack.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

}
