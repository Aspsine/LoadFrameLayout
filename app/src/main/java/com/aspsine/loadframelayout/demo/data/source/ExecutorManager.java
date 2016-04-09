package com.aspsine.loadframelayout.demo.data.source;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by aspsine on 16/1/21.
 */
public class ExecutorManager {

    private static final int MAX_THREAD_NUM = 3;
    private static Executor sExecutor;

    public static void execute(Runnable command) {
        ensureExecutor();
        sExecutor.execute(command);
    }

    private static void ensureExecutor() {
        if (sExecutor == null) {
            synchronized (ExecutorManager.class) {
                if (sExecutor == null) {
                    sExecutor = Executors.newFixedThreadPool(MAX_THREAD_NUM);
                }
            }
        }
    }

    public static void release() {
        sExecutor = null;
    }
}
