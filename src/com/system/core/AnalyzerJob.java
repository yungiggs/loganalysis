package com.system.core;

import com.system.core.struct.IAnalyzerJob;
import com.system.domain.AnalysisNode;
import com.system.domain.Log;
import com.system.enumeration.StatusCodeEnum;
import com.system.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-22.
 */
public abstract  class AnalyzerJob implements IAnalyzerJob{

    protected List<Log> logList;
    protected StringBuffer resultContent;

    public AnalyzerJob(List<Log> logList) {
        this.logList = logList;
        resultContent= new  StringBuffer();

    }
    @Override
    public void run() {

        List<AnalysisNode>  analysisNodeList = new ArrayList<AnalysisNode>();

        for (int i=0;i<logList.size()  ; i++){

            Log log =   logList.get(i);

            if(log.getStatusCode().equals(StatusCodeEnum.SUCCESS)){

                String key = setChildHook(log);
                addNode(analysisNodeList,key);

            }

        }
        //오름차순 정렬
        Utility.sortNodeList(analysisNodeList);

        //결과물 StringBuffer에 Append
        appendStringBuffer(analysisNodeList);

    }
    @Override
    public String  getResult(){

        run();
        return resultContent.toString();
    }

    protected void  addNode(List<AnalysisNode> list, String target){

        boolean isExist = false;

        for (int i=0;i<list.size();i++){

            AnalysisNode node =  list.get(i);

            if(node.getKey().equals(target)){

                isExist=true;

                int count=node.getCount()+1;

                node.setCount(count);
            }

        }
        if(!isExist){

            AnalysisNode node = new AnalysisNode();
            node.setKey(target);

            list.add(node);

        }

    }

    protected  abstract String setChildHook(Log log);

    protected  abstract void appendStringBuffer(List<AnalysisNode>  analysisNodeList);

}
