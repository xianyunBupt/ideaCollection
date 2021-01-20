package com.myProject.service.impl;

import com.myProject.dao.StudentDao;
import com.myProject.domain.Student;
import com.myProject.service.StudentService;
import com.myProject.util.mybatisUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao= mybatisUtil.getSqlSession().getMapper(StudentDao.class);
    @Override
    public List<Student> selectAllStudents() {
        return dao.selectStudents();
    }

    @Override
    public int addStudent(Student student) {
        return dao.insertStudent(student);
    }
}
