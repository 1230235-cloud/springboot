package com.laboratorio.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laboratorio.demo.model.Student;
import com.laboratorio.demo.repository.StudentRepository;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students/index";
    }

    @PostMapping("/students")
    public String saveStudent(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String matricula) {
        studentRepository.save(new Student(name, email, matricula));
        return "redirect:/students";
    }
}
