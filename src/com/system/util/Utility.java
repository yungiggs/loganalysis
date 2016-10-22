package com.system.util;

import com.system.domain.AnalysisNode;

import java.util.*;

/**
 * Created by Administrator on 2016-10-23.
 */
public class Utility {

    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
    public static String nvl(Map map, String key) {
        if(map == null){
            return "";
        }
        Object obj = null;
        if(map.containsKey(key)){
            obj = map.get(key);
        } else if (map.containsKey(key.toUpperCase())) {
            obj = map.get(key.toUpperCase());
        } else {
            return "";
        }
        return obj == null ? "" : String.valueOf(obj);

    }
    public static void sortNodeList(List<AnalysisNode> nodeList) {


        int maxIndex    =   0;

        AnalysisNode tempNode;
        for (int i = 0; i < nodeList.size()-1; i++)
        {
            maxIndex = i;
            for (int j = i+1; j < nodeList.size(); j++)
            {
                if ( nodeList.get(maxIndex).getCount() > nodeList.get(j).getCount() )
                    maxIndex = j;
            }
            tempNode = nodeList.get(i);
            nodeList.set(i, nodeList.get(maxIndex));
            nodeList.set(maxIndex, tempNode);
        }

    }

}
