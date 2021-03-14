package com.sxteng.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler {

    private Object target;

    public JdkDynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getSimpleName());
        return method.invoke(target,args);
    }


    public Object getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] proxiedInterfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, proxiedInterfaces, this);
    }
}
