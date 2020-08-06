package com.slenderman.actors;

import com.slenderman.game.Game;

public class SlenderMan {
  public static boolean isGameDone = false;
  public static int completions = 0;

  public static void killPlayer() {
    Game.isPlayerAlive = false;
    isGameDone = true;
  }

  public static void moveCloserToPlayer() {
    System.out.println(
      "---------------------------------------------------------------------------------------------------\n" +
        "You hear a screeching sound in the distance. Something is watching you and it is moving closer... \n" +
        "---------------------------------------------------------------------------------------------------\n");
  }

  public static void increaseCompletions() {
    setCompletions(getCompletions() + 1);
  }

  public static void setCompletions(int completions) {
    SlenderMan.completions = completions;
  }

  public static int getCompletions() {
    return completions;
  }
}
