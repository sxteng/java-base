package com.sxteng.proxy.jdk;

import com.sxteng.proxy.jdk.service.StudentService;
import com.sxteng.proxy.jdk.service.impl.StudentServiceImpl;
import org.junit.Test;

public class JdkProxyTest {


    public static void main(String[] args) {

        StudentServiceImpl studentService = new StudentServiceImpl();

        StudentService studentServiceProxy = (StudentService) ProxyFactory.getProxy(studentService);

        System.out.println(studentServiceProxy.hello());
    }

    @Test
    public void testJdkProxy(){

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        StudentServiceImpl studentService = new StudentServiceImpl();

        StudentService studentServiceProxy = (StudentService) ProxyFactory.getProxy(studentService);

        System.out.println(studentServiceProxy.hello());
    }



}
