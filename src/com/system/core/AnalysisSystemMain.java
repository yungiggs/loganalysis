package com.system.core;

import com.system.enumeration.AnalyzerJobEnum;
import com.system.util.ISytemConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev.yungiggs on 2016. 10. 21..
 */
public class AnalysisSystemMain {

    public static void main(String[] args){

        List jobList = new ArrayList();
        jobList.add(AnalyzerJobEnum.MAXAPIKEY);
        jobList.add(AnalyzerJobEnum.APISERVICE);
        jobList.add(AnalyzerJobEnum.BROWERRATE);

        FileLogAnalyzer dkFileLogAnalyzer= new DKLogAnalyzer();
        dkFileLogAnalyzer.loadFile(ISytemConstant.BASE_FILE_PATH,ISytemConstant.LOGFILE_NAME);
        dkFileLogAnalyzer.start(jobList);
        boolean result =  dkFileLogAnalyzer.putResultFile(ISytemConstant.BASE_FILE_PATH,ISytemConstant.OUTPUT_FILE_NAME);

        System.out.print("파일생성:"+result);

    }

}
