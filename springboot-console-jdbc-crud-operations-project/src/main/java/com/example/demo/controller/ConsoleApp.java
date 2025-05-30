package com.example.demo.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.StudentDAO;
import com.example.demo.model.Student;

@Component
public class ConsoleApp implements CommandLineRunner {

	@Autowired
	private StudentDAO dao;

	@Override
	public void run(String... args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n=== Student Management ===");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. View Student by ID");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
			case 1 -> {
				Student s = new Student();
				System.out.print("Enter name: ");
				s.setName(sc.nextLine());
				System.out.print("Enter email: ");
				s.setEmail(sc.nextLine());
				System.out.print("Enter course: ");
				s.setCourse(sc.nextLine());
				dao.save(s);
				System.out.println("Student added successfully.");
			}
			case 2 -> {
				List<Student> students = dao.findAll();
				students.forEach(stu -> System.out.println(
						stu.getId() + " | " + stu.getName() + " | " + stu.getEmail() + " | " + stu.getCourse()));
			}
			case 3 -> {
				System.out.print("Enter student ID: ");
				int id = sc.nextInt();
				Student stu = dao.findById(id);
				System.out.println(
						stu.getId() + " | " + stu.getName() + " | " + stu.getEmail() + " | " + stu.getCourse());
			}
			case 4 -> {
				Student s = new Student();
				System.out.print("Enter student ID to update: ");
				s.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter new name: ");
				s.setName(sc.nextLine());
				System.out.print("Enter new email: ");
				s.setEmail(sc.nextLine());
				System.out.print("Enter new course: ");
				s.setCourse(sc.nextLine());
				dao.update(s);
				System.out.println("Student updated successfully.");
			}
			case 5 -> {
				System.out.print("Enter student ID to delete: ");
				int id = sc.nextInt();
				dao.delete(id);
				System.out.println("Student deleted successfully.");
			}
			case 0 -> System.out.println("Exiting application...");
			default -> System.out.println("Invalid choice! Please try again.");
			}

		} while (choice != 0);

		sc.close();
	}
}