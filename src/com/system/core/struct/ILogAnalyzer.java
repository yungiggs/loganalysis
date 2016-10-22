package com.system.core.struct;

import com.system.core.AnalyzerJob;
import com.system.enumeration.AnalyzerJobEnum;

import java.util.Enumeration;
import java.util.List;

/**
 * Created by dev.yungiggs on 2016. 10. 21..
 */
public interface ILogAnalyzer {

    public void start(List<Enum> jobList);
    public void hook(AnalyzerJob job);

}