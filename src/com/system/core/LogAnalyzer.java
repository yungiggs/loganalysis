package com.system.core;

import com.system.core.struct.ILogAnalyzer;
import com.system.domain.Log;
import com.system.enumeration.AnalyzerJobEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-23.
 */
public abstract class LogAnalyzer implements ILogAnalyzer {

    protected  List<Log> logList;

    public LogAnalyzer() {
        logList = new ArrayList<Log>();

    }

    @Override
    public void start(List<Enum> jobList) {

        for (Enum item : jobList) {

            AnalyzerJob job =  getJob(item);
            hook(job);

        }
    }
    public AnalyzerJob getJob(Enum jobEnum) {

        JobFactory jobFactory   =   new JobFactory();

        return jobFactory.create((AnalyzerJobEnum) jobEnum,logList);
    }

}
