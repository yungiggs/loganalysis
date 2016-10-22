package com.system.core;

import com.system.domain.AnalysisNode;
import com.system.domain.Log;
import com.system.enumeration.StatusCodeEnum;
import com.system.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-23.
 */
public class BrowserJob extends  AnalyzerJob{

    public BrowserJob(List<Log> logList) {
        super(logList);
    }

    private int totalCount=0;


    @Override
    protected String setChildHook(Log log) {

        String browser = log.getBrowser().getValue();
        totalCount++;

        return browser;
    }

    @Override
    protected void appendStringBuffer(List<AnalysisNode> analysisNodeList) {

        resultContent.append("웹브라우저별 사용 비율\n");

        for (int i=analysisNodeList.size()-1;i>=0;i--){

            AnalysisNode node = analysisNodeList.get(i);
            double rate =  ((double)node.getCount()/totalCount) * 100;
            resultContent.append(node.getKey() + ":" + rate+ "% \n");
        }
        resultContent.append("\n\n\n");
    }

}
