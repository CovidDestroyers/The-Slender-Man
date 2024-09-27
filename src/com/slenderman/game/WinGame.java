package com.slenderman.game;

import java.util.ArrayList;
import java.util.Arrays;


public class WinGame {
  public ArrayList<String> winMessages = new ArrayList<>();

  public void winCondition(){
    winMessages.add("You walk slowly towards a lonely tree in the middle of a field...\n");
    winMessages.add("Something tells you to carve an X on the tree...\n");
    winMessages.add("You take the blade, and stab it into the tree...\n");
    winMessages.add("You breathe heavily as you begin to make the shape of an X on the tree...\n");
    winMessages.add("As you finish, you take a couple steps back...\n");
    winMessages.add("You begin to hear an overpowering screeching sound...\n");
    winMessages.add("You see something emerge from the shadows...\n");
    winMessages.add("The creature cracks and shifts around as it approaches you...\n");
    winMessages.add("The screeching becomes unbearable as you begin to lose your senses...\n");
    winMessages.add("You reach out for the blade and hold it front of you as the creature charges...\n");
    winMessages.add("...\n" + "...\n");
    winMessages.add("You have killed SlenderMan!\n");
    winMessages.add("You let out a sigh of relief as the sun rises over the thick woods.\n");
    winMessages.add("You see a possible exit in the distance, and begin your journey to freedom...\n");
    winMessages.add("\n"
      + "       __                            \n"
      + " /  | /  | /  |      /  | / /| |  /  \n"
      + "(___|(   |(   |     (   |( ( | | (   \n"
      + "    )|   )|   )     | / )| | | ) |   \n"
      + " __/ |__/ |__/      |/|/ | | |/  _   \n"
      + "                                     \n");
    winMessages.add("Thank you for playing!");

  }

  public void printWinMessage() throws InterruptedException {
    winCondition();
    for(String message : winMessages){
      Thread.sleep(2000);
      System.out.println(message);
    }
    System.exit(1);

  }
}
