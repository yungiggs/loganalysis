package com.system.core;

import com.system.domain.AnalysisNode;
import com.system.domain.Log;
import com.system.enumeration.StatusCodeEnum;
import com.system.util.Utility;

import java.util.*;

/**
 * Created by Administrator on 2016-10-23.
 */
public class APIServiceIDJob extends  AnalyzerJob {

    private final  int PRINTSIZE = 3;

    public APIServiceIDJob(List<Log> logList) {
        super(logList);
    }


    @Override
    protected String setChildHook(Log log) {

        String[] apiArray = log.getUrl().getPath().split("/");

        String  serviceID =apiArray[apiArray.length-1];

        return serviceID;
    }

    @Override
    protected void appendStringBuffer(List<AnalysisNode> analysisNodeList) {


        resultContent.append("상위"+PRINTSIZE+"개의 API ServiceID와 각각의 요청수\n");

        for (int i=1;i<=PRINTSIZE;i++) {

            AnalysisNode node = analysisNodeList.get(analysisNodeList.size() - i);

            resultContent.append(node.getKey() + ":" + node.getCount() + "\n");
        }

        resultContent.append("\n\n\n");

    }


}
