package com.myProject.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
/*
* 用来获取sqlsession
* */
public class mybatisUtil {
    //将类私有化，之后获取SqlSession只能通过类名.的方式，防止出现new对象再来调该方法的方式来制造内存垃圾
    private mybatisUtil(){}
    private static SqlSessionFactory factory=null;
    static{
        String config="mybatis.xml";
        InputStream in= null;
        try {
            in = Resources.getResourceAsStream(config);
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ThreadLocal<SqlSession> t=new ThreadLocal<>();
    //获得sqlSession对象
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=t.get();
        if(sqlSession==null){
            sqlSession=factory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }
    //关闭sqlSession对象
    public static void closeSqlSession(SqlSession session){
        if(session!=null){
            session.close();
            t.remove();//这句必须得加因为线程池可能没有将该线程销毁
        }
    }
}
