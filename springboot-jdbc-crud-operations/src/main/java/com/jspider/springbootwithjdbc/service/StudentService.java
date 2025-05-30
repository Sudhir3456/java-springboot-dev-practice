package com.jspider.springbootwithjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springbootwithjdbc.dao.StudentDAO;
import com.jspider.springbootwithjdbc.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO dao;

	public int addStudent(Student s) {
		return dao.save(s);
	}

	public List<Student> getAllStudents() {
		return dao.findAll();
	}

	public Student getStudentById(int id) {
		return dao.findById(id);
	}

	public int updateStudent(Student s) {
		return dao.update(s);
	}

	public int deleteStudent(int id) {
		return dao.delete(id);
	}
}