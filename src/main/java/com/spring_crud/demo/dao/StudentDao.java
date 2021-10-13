package com.spring_crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_crud.demo.model.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
