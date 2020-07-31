package com.slenderman.tools;

import com.slenderman.actors.SlenderMan;

import java.awt.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class OneMinuteTimer {
  Toolkit toolkit;
  Timer oneMinuteTimer;

  public OneMinuteTimer(int minutes) {
    toolkit = Toolkit.getDefaultToolkit();
    oneMinuteTimer = new Timer();
    oneMinuteTimer.schedule(new oneMinuteUp(), minutes * 60000);
  }


  class oneMinuteUp extends TimerTask {
    public void run() {
//      toolkit.beep();
      SlenderMan.moveCloserToPlayer();
      Sound.play(new File("oneMinute.wav"));
    }
  }
}
