package com.system.core;


import com.system.core.struct.IAnalyzerJob;
import com.system.core.struct.IJobFactory;
import com.system.domain.Log;
import com.system.enumeration.AnalyzerJobEnum;

import java.util.List;

/**
 * Created by Administrator on 2016-10-22.
 */
public  class JobFactory implements IJobFactory{

    public AnalyzerJob create(AnalyzerJobEnum jobEnum,List<Log> logList) {

        AnalyzerJob analyzerJob =null;

        switch (jobEnum){
            case MAXAPIKEY:
                analyzerJob = new MaxAPIkeyJob(logList);
                break;
            case APISERVICE:
                analyzerJob = new APIServiceIDJob(logList);
                break;
            case BROWERRATE:
                analyzerJob = new BrowserJob(logList);
                break;
        }
        return analyzerJob;
    }

}
