package com.system.core.struct;

import com.system.core.AnalyzerJob;
import com.system.domain.Log;
import com.system.enumeration.AnalyzerJobEnum;

import java.util.List;

/**
 * Created by Administrator on 2016-10-23.
 */
public interface IJobFactory {

    AnalyzerJob create(AnalyzerJobEnum jobEnum, List<Log> logList);
}
