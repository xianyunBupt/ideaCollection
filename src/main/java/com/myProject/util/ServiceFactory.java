package com.myProject.util;

public class ServiceFactory {
    //传递zs对象得到ls对象的过程
    public static Object getService(Object service){
        return new TransactionInvocationHandle(service).getProxy();
    }
}
