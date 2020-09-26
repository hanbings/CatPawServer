package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.service.ExecutorService;

/**
 * 线程池服务实现类
 * 任务申请线程 -> 线程池判断线程剩余数量 -> 执行任务 -> 若无强制要求超时后线程将被结束
 * @author Hanbings
 */
public class ExecutorServiceImpl implements ExecutorService {

}
