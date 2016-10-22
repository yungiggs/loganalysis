package com.system.domain;

import java.util.*;

/**
 * Created by dev.yungiggs on 2016. 10. 22..
 */
public class URL {

   private String query;
   private Map<String,String> param;

   public String getQuery() {
      return query;
   }

   public void setQuery(String query) {
      this.query = query;
   }

   public Map<String, String> getParam() {
      return param;
   }

   public void setParam(Map<String, String> param) {
      this.param = param;
   }

}