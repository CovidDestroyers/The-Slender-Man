package com.slenderman.tools;
import com.slenderman.actors.SlenderMan;
import com.slenderman.game.Game;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class LoseGameTimer {
  Toolkit toolkit;
  Timer timer = new Timer();

  public void gameTimer(int minutes) {
    Game.isPlayerAlive = true;
        timer.schedule(new TimerTask() {
      public void run() {
        killPlayerTask();
      }
    },minutes * 60000);
  }

  private void killPlayerTask() {
      toolkit = Toolkit.getDefaultToolkit();
      toolkit.beep();
      try {
        SlenderMan.killPlayer();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
}

