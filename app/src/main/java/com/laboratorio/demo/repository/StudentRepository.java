package com.laboratorio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laboratorio.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
