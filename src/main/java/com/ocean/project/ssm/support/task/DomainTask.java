package com.ocean.project.ssm.support.task;

import com.ocean.project.ssm.support.utils.DateUtils;

import java.util.Date;

/**
 * @author haiyang.li 2017/7/27.
 */
public class DomainTask {

    public void taskTest(){
        System.out.println("定时调度启动:当前时间---"+ DateUtils.format(new Date()));
    }
}