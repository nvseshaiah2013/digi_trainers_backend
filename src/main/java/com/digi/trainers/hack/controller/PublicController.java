package com.digi.trainers.hack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.trainers.hack.requests.LoginRequest;
import com.digi.trainers.hack.requests.StudentSignUpRequest;
import com.digi.trainers.hack.requests.TeacherSignUpRequest;
import com.digi.trainers.hack.responses.LoginResponse;
import com.digi.trainers.hack.responses.SuccessMessage;
import com.digi.trainers.hack.service.PublicService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/public")
public class PublicController {

	@Autowired
	private PublicService publicService;
	
	// Venkat Starts

	@PostMapping(value = "/registerStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> registerStudent(@RequestBody StudentSignUpRequest studentDetails)
			throws Exception {
		publicService.addStudent(studentDetails);
		return new ResponseEntity<SuccessMessage>(
				new SuccessMessage("Student Registration", "The Student Registered Successfully"), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/registerTeacher", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> registerTeacher(@RequestBody TeacherSignUpRequest teacherDetails)
			throws Exception {
		publicService.addTeacher(teacherDetails);
		return new ResponseEntity<SuccessMessage>(
				new SuccessMessage("Teacher Registration", "The Teacher Registered Successfully"), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> getAuthenticationToken(@RequestBody @Valid LoginRequest loginRequest)
			throws Exception {
		LoginResponse loginResponse = publicService.getAuthenticationToken(loginRequest.getUsername(),
				loginRequest.getPassword());
		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
	}
}
