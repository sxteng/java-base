package com.sxtemg.thread.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ExecutorServiceTest {


    public static void main(String[] args) {
        ExecutorService  executorService =  MCExecutors.getThreadPool();
        Future  future = executorService.submit(new Worker());

        try {
            Object object = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause().getMessage());
            e.printStackTrace();
        } finally {
        }
    }
}
