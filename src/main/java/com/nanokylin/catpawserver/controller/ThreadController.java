package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.service.impl.ThreadPoolServiceImpl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadController {
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
