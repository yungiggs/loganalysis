package com.system.enumeration;

/**
 * Created by Administrator on 2016-10-22.
 */
public enum AnalyzerJobEnum {

    MAXAPIKEY("최다호출APIKEY"),
    APISERVICE("API SERVICE ID ORDER BY"),
    BROWERRATE("브라우저사용비율");

    private String value;

    AnalyzerJobEnum(String key) {

        value = key;
    }
    public String getValue() {

        return value;
    }
    public static AnalyzerJobEnum getEnumByValue(String value){
        for (AnalyzerJobEnum item: AnalyzerJobEnum.values()){
            if(item.value.equals(value)){
                return item;
            }
        }
        return null;
    }
}
