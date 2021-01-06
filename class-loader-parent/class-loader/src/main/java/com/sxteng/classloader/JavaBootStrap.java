package com.sxteng.classloader;

import com.sxteng.classloader.service.StudentService;
import sun.misc.Launcher;

public class JavaBootStrap {


    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Class<StudentService> studentService = (Class<StudentService>) JavaBootStrap.class.getClassLoader().loadClass("com.sxteng.classloader" +
                ".service.StudentService");
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println("执行了 JavaBootStrap ");
    }
}
