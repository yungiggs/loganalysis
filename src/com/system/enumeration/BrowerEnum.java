package com.system.enumeration;

/**
 * Created by dev.yungiggs on 2016. 10. 22..
 */
public enum BrowerEnum {
    IE("IE"),
    FIREFOX("Firefox"),
    SAFARI("Safari"),
    CHROME("Chrome"),
    OPERA("Opera");

    private String value;

    BrowerEnum(String key){
        value=key;
    }
    public String getValue() {
        return value;
    }
    public static BrowerEnum getEnumByValue(String value){
        for (BrowerEnum item:BrowerEnum.values()){
            if(item.value.equals(value)){
                return item;
            }
        }
        return null;
    }

}
