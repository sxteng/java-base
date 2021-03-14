package com.sxteng.proxy.jdk;

public class ProxyFactory {

    public static  Object getProxy(Object target) {
        return new JdkDynamicProxy(target).getProxy();
    }
}
