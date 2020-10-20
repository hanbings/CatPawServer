package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolServiceReforgeImpl implements ThreadPoolService {
    private final int corePoolSize;
    private final int maximumPoolSize;
    private final long keepAliveTime;
    private final TimeUnit unit;
    private final BlockingQueue<Runnable> queue;
    private ThreadPoolExecutor threadPool;
    public ThreadPoolServiceReforgeImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                        BlockingQueue<Runnable> queue){
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.queue = queue;
    }
    @Override
    public ThreadPoolExecutor initThreadPoolService() {
        this.threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, unit, queue);
        return threadPool;
    }

    @Override
    public void execute(Thread thread) {
        threadPool.execute(thread);
    }

    @Override
    public void shutdown(String reason) {
        LogUtil log = new LogUtil();
        log.info(reason);
        threadPool.shutdown();
    }

    @Override
    public void shutdown() {
        threadPool.shutdown();
    }
}
