package com.slenderman.tools;

import com.slenderman.actors.SlenderMan;
import com.slenderman.game.Game;
import com.slenderman.musicplayer.SimplePlayer;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class OneMinuteTimer {
  Toolkit toolkit;
  Timer timer = new Timer();

  public void oneMinuteUp() {
    if(Game.isPlayerAlive) {
      SlenderMan.moveCloserToPlayer();
      scream();
    }
  }

  private void scream(){
        SimplePlayer player = new SimplePlayer("Scream.mp3");
  };

  public void startOneTimer() {
    timer.scheduleAtFixedRate(new TimerTask() {
      public void run() {
        oneMinuteUp();
      }
    }, 60000, 60000);
  }
}
