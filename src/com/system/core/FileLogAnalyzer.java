package com.system.core;

import com.system.core.struct.ILogAnalyzer;
import com.system.domain.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev.yungiggs on 2016. 10. 21..
 */
public abstract class FileLogAnalyzer extends  LogAnalyzer {

    protected StringBuffer resultContent = null;

    public FileLogAnalyzer() {

         resultContent = new StringBuffer();
    }
    public void loadFile(String path, String fileName) {

        BufferedReader br = null;
        InputStreamReader isr = null;
        FileInputStream fis = null;
        String temp=null;

        File file = new File(path+"/"+fileName);

        try {

            // 파일을 읽어들여 File Input 스트림 객체 생성
            fis = new FileInputStream(file);

            // File Input 스트림 객체를 이용해 Input 스트림 객체를 생성
            isr = new InputStreamReader(fis, "UTF-8");

            // Input 스트림 객체를 이용하여 버퍼를 생성
            br = new BufferedReader(isr);

            // 버퍼를 한줄한줄 읽어들여 내용 추출및 Log 객체로 변환
            while( (temp = br.readLine()) != null) {
              Log log =  convertLog(temp);
                logList.add(log);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {fis.close();} catch (IOException e) {e.printStackTrace();}

            try {isr.close();} catch (IOException e) {e.printStackTrace();}

            try {br.close();} catch (IOException e) {e.printStackTrace();}

        }
    }
    public  boolean putResultFile(String resultFile, String fileName){

        File    file = new File(resultFile+"/"+fileName) ;

        FileOutputStream fos    =   null;
        boolean result = true;

        try{

            if(!file.exists()){
                file.createNewFile();
            }

            fos =   new FileOutputStream(file);
            fos.write(resultContent.toString().getBytes());
            fos.flush();
            fos.close();

        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }finally {

            try {fos.close();} catch (IOException e) {e.printStackTrace();}
        }

        return result;
    }

    protected abstract Log convertLog(String content);



}
