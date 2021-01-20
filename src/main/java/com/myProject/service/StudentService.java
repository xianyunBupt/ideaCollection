package com.myProject.service;

import com.myProject.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllStudents();
    int addStudent(Student student);
}
