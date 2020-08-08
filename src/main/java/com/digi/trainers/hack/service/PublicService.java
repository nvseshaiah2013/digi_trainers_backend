package com.digi.trainers.hack.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.digi.trainers.hack.model.Admin;
import com.digi.trainers.hack.model.Student;
import com.digi.trainers.hack.model.Teacher;
import com.digi.trainers.hack.model.User;
import com.digi.trainers.hack.repository.AdminRepository;
import com.digi.trainers.hack.repository.StudentRepository;
import com.digi.trainers.hack.repository.TeacherRepository;
import com.digi.trainers.hack.repository.UserRepository;
import com.digi.trainers.hack.requests.AdminSignUpRequest;
import com.digi.trainers.hack.requests.StudentSignUpRequest;
import com.digi.trainers.hack.requests.TeacherSignUpRequest;
import com.digi.trainers.hack.responses.LoginResponse;

@Service
@Transactional
public class PublicService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private LoginUserService loginService;
	
	public void addStudent(StudentSignUpRequest request) throws Exception
	{
		User user = userRepository.findByUsername(request.getEmail());
		if(user!=null) {
			throw new Exception("Username already exists");
		}
		String salt = BCrypt.gensalt(10);
		User addedUser = userRepository.save(new User(request.getEmail(),BCrypt.hashpw(request.getPassword(), salt), "ROLE_STUDENT"));
		Student newStudent = new Student(addedUser.getId(),request.getName(),request.getPhone(),"","","", "", "");
		studentRepository.save(newStudent);
	}
	
	public void addTeacher(TeacherSignUpRequest request) throws Exception
	{
		User user = userRepository.findByUsername(request.getEmail());
		if(user!=null) {
			throw new Exception("Username already exists");
		}
		String salt = BCrypt.gensalt(10);
		User addedUser = userRepository.save(new User(request.getEmail(),BCrypt.hashpw(request.getPassword(), salt), "ROLE_TEACHER"));
		Teacher newTeacher = new Teacher(addedUser.getId(),request.getName(), "");
		teacherRepository.save(newTeacher);
	}
	
	public void addAdmin(AdminSignUpRequest request) throws Exception {
		User user = userRepository.findByUsername(request.getUsername());
		if(user!=null) {
			throw new Exception("Username already exists");
		}
		String salt = BCrypt.gensalt(10);
		User addedUser = userRepository.save(new User(request.getUsername(),BCrypt.hashpw(request.getPassword(), salt), "ROLE_ADMIN"));
		Admin newAdmin = new Admin(addedUser.getId(),request.getName(),request.getContactEmail(), request.getContactNo());
		adminRepository.save(newAdmin);
	}
	
	public LoginResponse getAuthenticationToken(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password");
		}

		final UserDetails userDetails = loginService.loadUserByUsername(username);

		final String jwt = jwtUtil.generateToken(userDetails);
		User user = userRepository.findByUsername(username);
		return new LoginResponse(jwt, user);
	}
}
