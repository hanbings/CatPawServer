package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.service.ConsoleService;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.utils.LogUtil;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {
    @Override
    public void initConsoleService(ThreadPoolService threadPoolService) {
        // 新建控制台线程
        Thread consoleThread = new ConsoleThread();
        consoleThread.setName("ConsoleThread");
        threadPoolService.execute(consoleThread);
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
