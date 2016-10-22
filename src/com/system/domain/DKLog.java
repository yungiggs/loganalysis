package com.system.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dev.yungiggs on 2016. 10. 21..
 */
public class DKLog extends Log{


    public void setDate(String dateString) {

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
           super.setDate(transFormat.parse(dateString));
        }catch (Exception e){
            super.setDate(null);
        }

    }

}
