package com.sxteng.javabase.test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class RefactorTest {

    private static HashMap<String,Method> methods = new HashMap<>();

    private static final String DEFAULT_FUNCTION_NAME = "defaultFunction";

    // 维护当前类方法名的最后一位,和方法
    // key 方法名最后一位,value 对应其方法名
    static {
        Method[] refactorMethods = RefactorTest.class.getDeclaredMethods();
        for (Method method : refactorMethods) {
            if (DEFAULT_FUNCTION_NAME.equals(method.getName())) {
                methods.put(method.getName(), method);
            } else {
                methods.put(method.getName().substring(method.getName().length() - 1), method);
            }
        }
    }

    // 数字没有方法能找到的关系就是,方法的最后一位是当前的数字
    public static void main(String[] args) {

        int actionCode = 1;

        RefactorTest refactor = new RefactorTest();

        Method method = methods.get(String.valueOf(actionCode));

        if (method == null) {
            method = methods.get(DEFAULT_FUNCTION_NAME);
        }

        try {
            method.invoke(refactor,  null);
        } catch (Exception e) {
            //TODO logger error
            // throws Exception
            e.printStackTrace();
        }
    }

        public void function1 () {
            System.out.println("1111");
        }

        public void function2 () {
            System.out.println("2222");
        }

        public void function3 () {
            //..
        }

        public void function4 () {
            //..
        }

        public void function5 () {
            //..
        }

        public void defaultFunction () {
            System.out.println("defaultFunction");
        }
}
