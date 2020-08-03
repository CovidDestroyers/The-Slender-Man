package com.slenderman.game;

import com.slenderman.scenes.Introduction;

public class WinMessage {
  public void winMessage() throws InterruptedException {
    int quickest = 2000;
    int middle = 3000;
    int slow = 4000;
    int slowest = 5000;

    Thread.sleep(quickest);
    System.out.println("You walk slowly towards a lonely tree in the middle of a field...\n");
    Thread.sleep(middle);
    System.out.println("Something tells you to carve an X on the tree...\n");
    Thread.sleep(middle);
    System.out.println("You take the blade, and stab it into the tree...\n");
    Thread.sleep(middle);
    System.out.println(
      "You breathe heavily as you begin to make the shape of an X on the tree...\n");
    Thread.sleep(middle);
    System.out.println("As you finish, you take a couple steps back...\n");
    Thread.sleep(middle);
    System.out.println("You begin to hear an overpowering screeching sound...\n");
    Thread.sleep(middle);
    System.out.println("You see something emerge from the shadows...\n");
    Thread.sleep(middle);
    System.out.println("The creature cracks and shifts around as it approaches you...\n");
    Thread.sleep(middle);
    System.out.println("The screeching becomes unbearable as you begin to lose your senses...\n");
    Thread.sleep(middle);
    System.out.println(
      "You reach out for the blade and hold it front of you as the creature charges...\n");
    Thread.sleep(middle);
    System.out.println("...\n");
    Thread.sleep(slow);
    System.out.println("...\n");
    Thread.sleep(slowest);
    System.out.println("You have killed SlenderMan!\n");
    Thread.sleep(middle);
    System.out.println("You let out a sigh of relief as the sun rises over the thick woods.\n");
    System.out.println(
      "You see a possible exit in the distance, and begin your journey to freedom...\n");
    Thread.sleep(slowest);
    System.out.println(
      "\n"
        + "       __                            \n"
        + " /  | /  | /  |      /  | / /| |  /  \n"
        + "(___|(   |(   |     (   |( ( | | (   \n"
        + "    )|   )|   )     | / )| | | ) |   \n"
        + " __/ |__/ |__/      |/|/ | | |/  _   \n"
        + "                                     \n");
    System.out.println("Thanks for playing " + Introduction.getPlayerName() + "!");
    Thread.sleep(9000);
    System.exit(1);
  }
}
