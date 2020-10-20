package com.nanokylin.catpawserver.service;


import java.util.concurrent.ThreadPoolExecutor;

public interface ThreadPoolService {

    /**
     * 加入一条线程到线程池
     *
     * @param thread 线程实例
     * @author Hanbings
     */
    void execute(Thread thread);

    /**
     * 将线程加入特定线程池
     *
     * @param threadPool 线程池
     * @param thread     线程实例
     */
    void execute(ThreadPoolExecutor threadPool, Thread thread);

    /**
     * 关闭线程池
     * 一个有理由的方法和一个没有的
     *
     * @param reason 结束理由
     */
    void shutdown(String reason);

    void shutdown();
}
