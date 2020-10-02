package com.nanokylin.catpawserver.service;


public interface ThreadPoolService {
    /**
     * 初始化线程池
     * 初始化前必须先设置Resources的参数 否则将报错并终止程序
     * @author Hanbings
     */
    public void initThreadPoolService();

    /**
     * 加入一条线程到线程池
     * @param thread 线程实例
     * @author Hanbings
     */
    public void execute(Thread thread);

    /**
     * 关闭线程池
     * 一个有理由的方法和一个没有的
     * @param reason 结束理由
     */
    public void shutdown(String reason);
    public void shutdown();
}
