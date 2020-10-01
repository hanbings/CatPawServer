package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolServiceImpl implements ThreadPoolService {
    ThreadPoolExecutor threadPool;
    @Override
    public void initThread() {
        threadPool = new ThreadPoolExecutor(Resources.corePoolSize,Resources.maximumPoolSize,
                Resources.keepAliveTime,Resources.unit,Resources.queue,Resources.handle);
    }
    @Override
    public void execute(java.lang.Thread thread){
        threadPool.execute(thread);
    }
}
