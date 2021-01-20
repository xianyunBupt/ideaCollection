package com.myProject.dao;

import com.myProject.domain.Student;

import java.util.List;

//dao层的接口
public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
}
