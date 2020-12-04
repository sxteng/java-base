package com.sxtemg.thread.service;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MCThreadFactory implements ThreadFactory {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);

    private final ThreadGroup group;

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    private final String namePrefix;
    
    /** 无法捕获的异常统一处理 */
    private final Thread.UncaughtExceptionHandler handler = null;

    MCThreadFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "MC-" + poolNumber.getAndIncrement() + "-thread-";
    }

    MCThreadFactory(Thread.UncaughtExceptionHandler handler) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "MC-" + poolNumber.getAndIncrement() + "-thread-";
       // this.handler = handler;
    }

    public Thread newThread(Runnable r) {

        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);

        if (t.isDaemon()) {
            t.setDaemon(false);

        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }

/*        //异常处理
        if(null != this.handler) {
            t.setUncaughtExceptionHandler(handler);
        }*/
        return t;
    }

}
