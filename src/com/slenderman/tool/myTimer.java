package com.slenderman.tool;
import java.util.Date;

public class myTimer {
      //constructor
      public myTimer() {
          //initialize members
        Date date = new Date();
        startTime = date.getTime();
      }

      //member variable date lives in the instance of Timer class
      long startTime;

      public long timePassed() {
          Date date = new Date();
          long currentTime = date.getTime();
          return currentTime - startTime;
      }
}
