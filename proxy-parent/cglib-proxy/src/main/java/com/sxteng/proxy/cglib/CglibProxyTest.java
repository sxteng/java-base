package com.sxteng.proxy.cglib;

public class CglibProxyTest {


    public static void main(String[] args) {

        StudentServiceImpl studentService = new StudentServiceImpl();

        StudentServiceImpl studentServiceProxy = (StudentServiceImpl) ProxyFactory.getProxy(studentService);

        System.out.println(studentServiceProxy.hello());
    }





}
