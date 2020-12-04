package com.sxtemg.thread.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MCExecutors {

    private static final int DEFAULT_THREADS = Runtime.getRuntime().availableProcessors() + 1;


    private static final ExecutorService executor = new ThreadPoolExecutor(DEFAULT_THREADS, DEFAULT_THREADS,
            0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new MCThreadFactory());


    public static ExecutorService getThreadPool() {
        return executor;
    }


}
