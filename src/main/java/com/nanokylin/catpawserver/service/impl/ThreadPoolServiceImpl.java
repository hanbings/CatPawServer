package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolServiceImpl implements ThreadPoolService {
    private final ThreadPoolExecutor threadPool;

    /**
     * 这个构造方法有点多余来着
     * 先放着
     *
     * @param threadPool 线程池
     */
    public ThreadPoolServiceImpl(ThreadPoolExecutor threadPool) {
        this.threadPool = threadPool;
    }

    /**
     * 设置一个线程池
     *
     * @param corePoolSize    线程池的基本大小
     * @param maximumPoolSize 最大线程数
     * @param keepAliveTime   保持存活时间
     * @param unit            线程池维护线程所允许的空闲时间的单位
     * @param queue           线程池所使用的缓冲队列
     */
    public ThreadPoolServiceImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                 BlockingQueue<Runnable> queue) {
        this.threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, unit, queue);
    }

    /**
     * 获取线程池
     *
     * @return 线程池
     */
    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    /**
     * 将线程加入线程池
     *
     * @param thread 线程实例
     */
    @Override
    public void execute(Thread thread) {
        this.threadPool.execute(thread);
    }

    /**
     * 将线程加入特定线程池
     *
     * @param threadPool 线程池
     * @param thread     线程实例
     */
    @Override
    public void execute(ThreadPoolExecutor threadPool, Thread thread) {
        threadPool.execute(thread);
    }

    @Override
    public void shutdown(String reason) {
        LogUtil log = new LogUtil();
        log.info(reason);
        this.threadPool.shutdown();
    }

    @Override
    public void shutdown() {
        this.threadPool.shutdown();
    }
}
