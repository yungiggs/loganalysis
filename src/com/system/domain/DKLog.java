package com.system.domain;

import com.system.enumeration.BrowserEnum;
import com.system.enumeration.StatusCodeEnum;

import java.net.URL;
import java.text.SimpleDateFormat;

/**
 * Created by dev.yungiggs on 2016. 10. 21..
 */
public class DKLog extends Log{


    public void setStatusCode(String statusCodeString) {

        super.setStatusCode( StatusCodeEnum.getEnumByValue(statusCodeString));
    }

    public void setBrower(String  browerString) {

        super.setBrowser( BrowserEnum.getEnumByValue(browerString));
    }

    public void setUrl(String stringUrl) {

        try{

            URL url = new URL(stringUrl);
            super.setUrl(url);
        } catch (Exception e){


        }

    }

    public void setDate(String dateString) {

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
           super.setDate(transFormat.parse(dateString));
        }catch (Exception e){
            super.setDate(null);
        }

    }

}
