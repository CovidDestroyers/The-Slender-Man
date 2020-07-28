package com.slenderman.actors;

//import com.slenderman.scenes.LoseGameScene;
import com.slenderman.scenes.Scene;

public class SlenderMan {

  public static void killPlayer() throws InterruptedException {
    System.out.println("---------------------------------------------------------------------------------------------------\n" +
      "The screeching overpowers all of your senses, you become paralyzed... \n" +
      "SlenderMan emerges from the shadows and wraps his long slimy fingers around your neck and... \n" +
      "       __                  __   __   __      \n" +
      " /  | /  | /  |      /    /  | /    /     /  \n" +
      "(___|(   |(   |     (    (   |(___ (___  (   \n" +
      "    )|   )|   )     |   )|   )    )|     |   \n" +
      " __/ |__/ |__/      |__/ |__/  __/ |__   _   \n" +
      "                                             ");
  }

  public static void moveCloserToPlayer() {
    System.out.println("---------------------------------------------------------------------------------------------------\n" +
      "You hear a screeching sound in the distance. Something is watching you and it is moving closer... \n");
  }

}
