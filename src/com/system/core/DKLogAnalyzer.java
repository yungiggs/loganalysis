package com.system.core;



import com.system.domain.DKLog;
import com.system.domain.Log;
import com.system.enumeration.AnalyzerJobEnum;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-22.
 */

public class DKLogAnalyzer extends FileLogAnalyzer {

    public DKLogAnalyzer() {


    }
    @Override
    protected Log convertLog(String content) {

        DKLog log = new DKLog();

        content= content.replaceAll("\\[","");
        String[] tempContentArray =  content.split("]");

        log.setStatusCode(tempContentArray[0].trim());
        log.setUrl(tempContentArray[1].trim());
        log.setBrower(tempContentArray[2].trim());
        log.setDate(tempContentArray[3].trim());

        return log;
    }

    @Override
    public void hook(AnalyzerJob job) {
       String test =  job.getResult();
        resultContent.append(test);

    }
}
