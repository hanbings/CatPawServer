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

        /////////////////////////////////// Thread Test ////////////////////////////////////////////
        Thread test = new Test();
        threadSetter.getThreadPool().execute(test);
        ///////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void execute(String command) {
        if (command.contains("help")){
            System.out.println("假装这是一个help");
        }
    }
}
class ConsoleThread extends Thread{
    private static final LogUtil log = new LogUtil();
    private static final ConsoleService consoleService = new ConsoleServiceImpl();
    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            String command = sc.nextLine();
            consoleService.execute(command);
        }
    }
}
class Test extends Thread{
    private static final LogUtil log = new LogUtil();
    @Override
    public void run(){
        for (;;){
            try {
                log.info("Hello World");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
