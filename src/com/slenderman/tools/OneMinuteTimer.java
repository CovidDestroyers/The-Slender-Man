package com.slenderman.tools;

import com.slenderman.actors.SlenderMan;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class OneMinuteTimer {
  Toolkit toolkit;
  Timer timer = new Timer();

  public void oneMinuteUp() {
    toolkit = Toolkit.getDefaultToolkit();
    toolkit.beep();
    SlenderMan.moveCloserToPlayer();
  }

  public void startOneTimer() {
    timer.scheduleAtFixedRate(new TimerTask() {
      public void run() {
        oneMinuteUp();
      }
    }, 0, 60000);
  }
}
