package com.studentManagement_JPA.System.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentManagement_JPA.System.demo.entity.Student;
import com.studentManagement_JPA.System.demo.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping
	public String liststudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add_Student";
	}

	@PostMapping
	public String saveStudent(@ModelAttribute("student") Student student, HttpSession session) {
		studentService.saveStudent(student);
		session.setAttribute("successMessage", "Student Added");
		return "redirect:/students";
	}

	@GetMapping("/update/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "update_student";
	}

	@PostMapping("/{id}")
	public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model,
			HttpSession session) {
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setEmail(student.getEmail());

		studentService.saveStudent(existingStudent);
		session.setAttribute("successMessage", "Student Updated");
		return "redirect:/students";
	}

	// Delete student
	@GetMapping("/{id}")
	public String deleteStudent(@PathVariable Long id, HttpSession session) {
		studentService.deleteStudentById(id);
		session.setAttribute("successMessage", "Student Deleted");
		return "redirect:/students";
	}

	// Handler to remove popup success message as blank
	@PostMapping("/resetSuccessMessage")
	public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
		session.removeAttribute("successMessage");
		return ResponseEntity.ok().build();
	}

}
