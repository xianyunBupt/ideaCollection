package com.myProject.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class TransactionInvocationHandle implements InvocationHandler {
    // 目标对象zs
    private Object target;
    public TransactionInvocationHandle(Object target) {
        this.target=target;
    }
//代理类的业务方法
    //发起者的动态代理方法ls
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        SqlSession session=null;
        Object obj=null;
        try{
            session=mybatisUtil.getSqlSession();
            //处理业务逻辑
            //目标对象target的动态代理
            obj=method.invoke(target,objects);
            //处理业务逻辑完毕后提交事务
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }
//        finally{
//            mybatisUtil.closeSqlSession(session);
//        }
        return obj;
    }
    //获取动态代理对象ls对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
