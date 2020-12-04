package com.sxtemg.thread.service;

import java.util.concurrent.Callable;

public class Worker implements Callable<Void> {


    @Override
    public Void call() throws Exception {
        System.out.println("==================");
        throw new RuntimeException("99999");
    }
}
