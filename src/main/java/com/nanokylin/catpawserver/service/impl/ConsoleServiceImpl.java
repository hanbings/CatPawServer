package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.service.ConsoleService;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.utils.LogUtil;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {
    @Override
    public void execute(String command) {
        if (command.contains("help")){
            System.out.println("假装这是一个help");
        }
    }
}
