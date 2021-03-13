package com.sxteng.javabase.test;

public class Testinstance {

    public static void main(String[] args) {
        Instance instance1 =  Instance.getInstance();
        Instance instance2 =  Instance.getInstance();

/*        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(instance1 == instance2);
    }
}