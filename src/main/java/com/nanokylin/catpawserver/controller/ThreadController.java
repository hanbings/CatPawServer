package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Config;
import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.service.impl.ThreadPoolServiceImpl;
import com.nanokylin.catpawserver.service.impl.ThreadPoolServiceReforgeImpl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadController {
    public void initThreadPool(){
        // 设置线程
        /*this.setThread((int) Config.getConfig("corePoolSize"),(int) Config.getConfig("maximumPoolSize"),
                Config.getLong("keepAliveTime"), TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>((int) Config.getConfig("queue")));
        // 启动线程池服务
        this.setThreadPool();*/
        Resources.threadPoolService = new ThreadPoolServiceReforgeImpl((int) Config.getConfig("corePoolSize"),(int) Config.getConfig("maximumPoolSize"),
                Config.getLong("keepAliveTime"), TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>((int) Config.getConfig("queue")));
        Resources.threadPoolService.initThreadPoolService();
        Thread t = new Test();
        Resources.threadPoolService.execute(t);
    }
    public void setThread(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                          BlockingQueue<Runnable> queue){
        Resources.corePoolSize = corePoolSize;
        Resources.maximumPoolSize = maximumPoolSize;
        Resources.keepAliveTime = keepAliveTime;
        Resources.queue = queue;
        Resources.unit = unit;
    }
    public void setThreadPool(){
        // 实例化Res中的线程池对象
        Resources.threadPoolService = new ThreadPoolServiceImpl();
        // 初始化线程池
        Resources.threadPoolService.initThreadPoolService();
    }
    public ThreadPoolService getThreadPool(){
        return Resources.threadPoolService;
    }
}
class Test extends Thread{
    @Override
    public void run(){
        for(;;){
            try {
                sleep(1000);
                System.out.println("Thread Test");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
