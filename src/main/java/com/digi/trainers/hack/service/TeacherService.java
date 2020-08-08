package com.digi.trainers.hack.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.trainers.hack.model.Event;
import com.digi.trainers.hack.model.OnlineClass;
import com.digi.trainers.hack.model.Student;
import com.digi.trainers.hack.model.Teacher;
import com.digi.trainers.hack.repository.EventRepository;
import com.digi.trainers.hack.repository.OnlineClassRepository;
import com.digi.trainers.hack.repository.StudentRepository;
import com.digi.trainers.hack.repository.TeacherRepository;
import com.digi.trainers.hack.requests.NewEventRequest;

@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepo;

	@Autowired
	private OnlineClassRepository classRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private EventRepository eventRepo;

	public void addNewClass(String name, int id) throws Exception {
		Optional<Teacher> teacher = teacherRepo.findById(id);
		if (teacher.isPresent()) {
			OnlineClass onlineClass = new OnlineClass(name);
			OnlineClass savedObj = classRepo.save(onlineClass);
			teacher.get().addClass(savedObj);
		} else {
			throw new Exception("Teacher with the given Id does not exist");
		}
		teacherRepo.save(teacher.get());
	}

	public void addStudentToClass(int teacherId, int studentId, int classId) throws Exception {
		Optional<OnlineClass> onlineClass = classRepo.findById(classId);
		if (onlineClass.isPresent()) {
			Optional<Teacher> teacher = teacherRepo.findById(teacherId);
			if (teacher.isPresent()) {
				if (teacher.get().getClasses().contains(onlineClass.get())) {
					Optional<Student> student = studentRepo.findById(studentId);
					if (student.isPresent()) {
						onlineClass.get().getStudents().add(student.get());
						student.get().setOnlineClass(onlineClass.get());
						classRepo.save(onlineClass.get());
					} else
						throw new Exception("Student with given id does not exist");
				} else
					throw new Exception("Teacher does not own this class");
			} else {
				throw new Exception("Teacher With given id not found");
			}
		} else
			throw new Exception("Online Class with the given id does not exist");
	}

	public void addEventToClass(int id, NewEventRequest eventRequest) throws Exception {
		Optional<Teacher> teacher = teacherRepo.findById(id);
		if (teacher.isPresent()) {
			Optional<OnlineClass> onlineClass = classRepo.findById(eventRequest.getClassId());
			if (onlineClass.isPresent()) {
				if (teacher.get().getClasses().contains(onlineClass.get())) {
					Event event = new Event(eventRequest.getDescription(), eventRequest.getSubject(),
							eventRequest.getTopic(), eventRequest.getMeetingLink(), eventRequest.getPptLink(),
							eventRequest.getAssignmentLink(), teacher.get(), eventRequest.getEventDate(),
							onlineClass.get(), eventRequest.getAttendanceLink());
					eventRepo.save(event);
				} else {
					throw new Exception("Online Class do not belong to Teacher");
				}
			} else {
				throw new Exception("Online Class Id does not Exist");
			}
		} else
			throw new Exception("Teacher with given Id not Found");
	}
}
