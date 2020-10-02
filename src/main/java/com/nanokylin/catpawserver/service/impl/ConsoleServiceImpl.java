package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.common.ThreadSetter;
import com.nanokylin.catpawserver.service.ConsoleService;
import com.nanokylin.catpawserver.utils.LogUtil;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {
    @Override
    public void initConsoleService() {
        // 新建控制台线程
        Thread consoleThread = new ConsoleThread();
        consoleThread.setName("ConsoleThread");
        // 获取线程池放入线程
        ThreadSetter threadSetter = new ThreadSetter();
        threadSetter.getThreadPool().execute(consoleThread);
    }
}
class ConsoleThread extends Thread{
    private static final LogUtil log = new LogUtil();
    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            System.out.print(">");
            String command = sc.nextLine();
            log.info(command);
        }
    }
}
