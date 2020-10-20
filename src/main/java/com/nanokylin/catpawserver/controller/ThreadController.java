package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Config;
import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.service.impl.ThreadPoolServiceImpl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadController {
    public void initThreadPool() {
        // 设置线程
        Resources.threadPoolService = new ThreadPoolServiceImpl((int) Config.getConfig("corePoolSize"), (int) Config.getConfig("maximumPoolSize"),
                Config.getLong("keepAliveTime"), TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>((int) Config.getConfig("queue")));
    }

    public ThreadPoolService getThreadPool() {
        return Resources.threadPoolService;
    }
}
