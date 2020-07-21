package com.slenderman.tools;
import com.slenderman.actors.SlenderMan;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class LoseGameTimer {
  Toolkit toolkit;
  Timer loseGameTimer;

  public LoseGameTimer(int minutes) {
    toolkit = Toolkit.getDefaultToolkit();
    loseGameTimer = new Timer();
    loseGameTimer.schedule(new KillPlayerTask(), minutes * 60000);
  }


  class KillPlayerTask extends TimerTask {
    public void run() {
      toolkit.beep();
      SlenderMan.killPlayer();
    }
  }


}
