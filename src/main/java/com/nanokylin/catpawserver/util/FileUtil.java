package com.nanokylin.catpawserver.util;

import com.nanokylin.catpawserver.CatPawServer;

import java.io.*;
import java.util.Objects;

/**
 * 将jar内的文件复制到jar包外的指定目录下
 * @author Hanbings
 */
public class FileUtil {
    private static final LogUtil log = new LogUtil();

    /**
     * 释放文件到Jar外目录
     * @param path 需要释放的文件
     * @param outPath 释放的目标目录
     */
    public void copyFileOutOfJar(String path,String outPath){
        InputStream is = CatPawServer.class.getResourceAsStream(path);// 流式读取jar包内文件，使用classpath
        File f = new File(outPath);// 指定输出文件
        File fp = new File(f.getParent());// 输出文件的父目录
        if (!fp.exists()) {// 父目录不存在时先创建
            boolean mkdir = fp.mkdirs();
            log.info("创建配置文件目录 " + mkdir);
        }
        if (!f.exists()) {// 文件不存在时先创建
            try {
                boolean makeFile = f.createNewFile();
                log.info("创建配置文件 " + makeFile);
            } catch (IOException e) {
                log.info(e);
            }
        }
        OutputStream os = null;// 创建输出流
        try {
            os = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            log.info(e);
        }
        int index = 0;// 当前读取的位数
        byte[] bytes = new byte[1024];// 指定每次读取的位数，这里以1024为例
        // 开始读取文件，一遍读取一边输出文件。每次读取1024的长度并储存于bytes这个数组中，然后写入至目标文件
        while (true) {
            try {
                if (!((index = is.read(bytes)) != -1)) break;
                Objects.requireNonNull(os).write(bytes, 0, index);// 输出文件，write()方法参数分别为：写入的数据、开始写入的位置（0为从开头写入），写入长度
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
// 关闭流并保存文件
        try {
            Objects.requireNonNull(os).flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
