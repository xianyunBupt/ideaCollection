package com.myProject;

import com.myProject.util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class studentTest {
    public static void main(String[] args) {
        SqlSession session= mybatisUtil.getSqlSession();
      /*  List<Student> students=session.selectList("com.myProject.dao.StudentDao.selectStudents");
        for(Student stu:students){
            System.out.println("学生信息为:"+stu);
        }*/
      /*Student student=session.selectOne("com.myProject.dao.StudentDao.selectStudentById",1);
        System.out.println(student);*/
//      Student student=new Student(2,"wangwu",198);
      int num=session.delete("removeStudent",2);
      session.commit();
        System.out.println(num);
        mybatisUtil.closeSqlSession(session);
    }
}
