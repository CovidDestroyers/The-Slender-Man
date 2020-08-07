package com.slenderman.tools;

import com.slenderman.actors.SlenderMan;

import java.util.Timer;
import java.util.TimerTask;

public class SlenderManProgression {
  public Timer timer;

  public SlenderManProgression(int minutes) {
    timer = new Timer();
    timer.schedule(new SlenderManTimer(), minutes * 60_000);
  }

  static class SlenderManTimer extends TimerTask {
    public void run() {
      SlenderMan.increaseCompletions();
    }
  }
}
