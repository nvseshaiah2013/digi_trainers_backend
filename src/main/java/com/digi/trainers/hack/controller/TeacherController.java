package com.digi.trainers.hack.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.trainers.hack.model.User;
import com.digi.trainers.hack.repository.UserRepository;
import com.digi.trainers.hack.requests.AddClassRequest;
import com.digi.trainers.hack.requests.AddStudentToClassRequest;
import com.digi.trainers.hack.requests.NewEventRequest;
import com.digi.trainers.hack.responses.SuccessMessage;
import com.digi.trainers.hack.service.JwtUtil;
import com.digi.trainers.hack.service.TeacherService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/teacher")
public class TeacherController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeacherService teacherService;

	@PostMapping(value = "/class/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addClass(@RequestBody AddClassRequest classRequest,
			HttpServletRequest request) throws Exception {
		int id = getIdByJWT(request);
		teacherService.addNewClass(classRequest.getName(), id);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Class Message", "Class Added"),
				HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/event/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addNewEvent(@RequestBody NewEventRequest eventRequest, HttpServletRequest request) throws Exception {
		int id = getIdByJWT(request);
		teacherService.addEventToClass(id,eventRequest);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Event Message", "Event Added"),
				HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "student/add" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addStudent(@RequestBody AddStudentToClassRequest studentRequest, HttpServletRequest request) throws Exception {
		int id = getIdByJWT(request);
		teacherService.addStudentToClass(id,studentRequest.getStudentId(), studentRequest.getClassId());
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Student Message", "Student Added"),
				HttpStatus.ACCEPTED);
	}
	
	public int getIdByJWT(HttpServletRequest request) throws Exception {
		String header = request.getHeader("Authorization");
		String token = header.substring(7);
		String username = jwtUtil.extractUsername(token);
		User user = userRepository.findByUsername(username);
		return user.getId();

	}

}
