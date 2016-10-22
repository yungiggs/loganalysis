package com.system.enumeration;

/**
 * Created by dev.yungiggs on 2016. 10. 21..
 */
public enum StatusCodeEnum {
    SUCCESS("200"),
    ERROR_PAGE_NOT_FOUND("400"),
    ERROR_NOT_PARAM("10");

    private String value;
    StatusCodeEnum(String key){
        value=key;
    }
    public String getValue() {
        return value;
    }
    public static StatusCodeEnum getEnumByValue(String value){
        for (StatusCodeEnum item:StatusCodeEnum.values()){
            if(item.value.equals(value)){
                return item;
            }
        }
        return null;
    }
}
