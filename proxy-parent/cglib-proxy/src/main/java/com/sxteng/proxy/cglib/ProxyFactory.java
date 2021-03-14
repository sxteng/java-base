package com.sxteng.proxy.cglib;

public class ProxyFactory {


    public static  Object getProxy(Object target) {
        return new CglibDynamicProxy(target).getProxy();
    }
}
