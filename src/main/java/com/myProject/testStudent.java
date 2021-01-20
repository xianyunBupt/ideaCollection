package com.myProject;

import com.myProject.domain.Student;
import com.myProject.service.StudentService;
import com.myProject.service.impl.StudentServiceImpl;
import com.myProject.util.ServiceFactory;

import java.util.List;

public class testStudent {
    public static void main(String[] args) {
        /*StudentService service= (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        List<Student> students=service.selectAllStudents();
        for(Student stu:students){
            System.out.println(stu);
        }
*/
        //使用动态代理获取处理事务的ls对象
        StudentService service= (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        Student student=new Student(8,"xuzheng",89);
        int num=service.addStudent(student);
        System.out.println(num);
    }
}
