package com.slenderman.tools;
import com.slenderman.actors.SlenderMan;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
  Toolkit toolkit;
  Timer timer;
  public GameTimer(int minutes) {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new RemindTask(), minutes * 60000);
  }

  class RemindTask extends TimerTask {
    public void run() {
      toolkit.beep();
      SlenderMan.killPlayer();
    }
  }


}
