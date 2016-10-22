package com.system.core;

import com.system.core.AnalyzerJob;
import com.system.domain.AnalysisNode;
import com.system.domain.Log;
import com.system.enumeration.StatusCodeEnum;
import com.system.util.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-10-22.
 */
public class MaxAPIkeyJob extends AnalyzerJob{


    public MaxAPIkeyJob(List<Log> logList) {
        super(logList);
    }


    @Override
    protected String setChildHook(Log log) {


        Map param = Utility.getQueryMap(log.getUrl().getQuery());
        String apikey = Utility.nvl(param,"apikey");

        return apikey;
    }

    @Override
    protected void appendStringBuffer(List<AnalysisNode> analysisNodeList) {

        String maxKey = "";

        if(analysisNodeList.size()>0){

            AnalysisNode  node =  analysisNodeList.get(analysisNodeList.size()-1);
            maxKey=node.getKey();
        }

        resultContent.append("최다호출 APIKEY");
        resultContent.append("\n");
        resultContent.append(maxKey);
        resultContent.append("\n\n\n");

    }


}
