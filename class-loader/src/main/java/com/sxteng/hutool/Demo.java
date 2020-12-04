package com.sxteng.hutool;

import com.sxteng.hutool.service.StudentService;
import com.sxteng.hutool.loader.MyClassLoader;

import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) throws Exception {

        MyClassLoader myClassLoader = new MyClassLoader(null);

        Class<Demo> demoClass = (Class<Demo>)myClassLoader.loadClass("com.sxteng.hutool.Demo");

     /*   Class<Demo> demoClass = (Class<Demo>) Class.forName("Demo",true
                ,myClassLoader);*//*   Class<Demo> demoClass = (Class<Demo>) Class.forName("Demo",true
                ,myClassLoader);*/
        Object demo = demoClass.getConstructor().newInstance();
        Method method =  demo.getClass().getMethod("test",null);
        demoClass.getClassLoader();
        method.invoke(demo,null);
        System.out.println(demo instanceof Demo );
        StudentService studentService = new StudentService();
        studentService.getStudent();

    }

    public   void test(){
        StudentService studentService = new StudentService();
        studentService.getStudent();
    }
}
