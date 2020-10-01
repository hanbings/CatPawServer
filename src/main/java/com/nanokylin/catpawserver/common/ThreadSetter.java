package com.nanokylin.catpawserver.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadSetter {
    public void setThread(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                          BlockingQueue<Runnable> queue,String threadNameFormat){
        Resources.corePoolSize = corePoolSize;
        Resources.maximumPoolSize = maximumPoolSize;
        Resources.keepAliveTime = keepAliveTime;
        Resources.queue = queue;
        Resources.unit = unit;
        // TODO: 线程格式
        Resources.threadNameFormat = threadNameFormat;
    }
}
