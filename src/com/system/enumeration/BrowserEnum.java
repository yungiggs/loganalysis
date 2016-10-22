package com.system.enumeration;

/**
 * Created by dev.yungiggs on 2016. 10. 22..
 */
public enum BrowserEnum {
    IE("IE"),
    FIREFOX("Firefox"),
    SAFARI("Safari"),
    CHROME("Chrome"),
    OPERA("Opera");

    private String value;

    BrowserEnum(String key){
        value=key;
    }
    public String getValue() {
        return value;
    }
    public static BrowserEnum getEnumByValue(String value){
        for (BrowserEnum item: BrowserEnum.values()){
            if(item.value.equals(value)){
                return item;
            }
        }
        return null;
    }

}
