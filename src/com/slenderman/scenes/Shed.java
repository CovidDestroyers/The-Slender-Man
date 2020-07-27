package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Shed extends Scene {
  private Scanner choice;
  private Player player;

  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("shed");
  private final Item Key = ItemDirector.findThisItem("key", itemsInThisScene);

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Shed() {
    setSceneName("shed");
    setItemsInScene(itemsInThisScene);
  }

  public Shed(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
    setSceneName("shed");
    setItemsInScene(itemsInThisScene);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    this.player = player;

    choice = in;
    inFrontOfShed();
  }

  private void inFrontOfShed() throws InterruptedException {
    String choice;
    System.out.println(Scene.ANSI_WHITE + "\nThere is an old Shed in front of you.");
    System.out.println("What would you like to do?");
    System.out.println(
        " Type "
            + Scene.ANSI_GREEN
            + "\"0\" "
            + Scene.ANSI_WHITE
            + ": \"Go into the Shed\" "
            + "\n Type "
            + Scene.ANSI_GREEN
            + "\"1\" "
            + Scene.ANSI_WHITE
            + ": \"Go somewhere else\"");

    choice = playerChoice();
    if (choice.equals("0")) {
      stepIntoTheShed();
    } else if (choice.equals("1")) {
      goSomewhereElse();
    } else {
      System.out.println(
          "Wrong input, try entering "
              + Scene.ANSI_GREEN
              + "0 "
              + Scene.ANSI_WHITE
              + "or "
              + Scene.ANSI_GREEN
              + "1"
              + Scene.ANSI_WHITE
              + ".");
      inFrontOfShed();
    }
  }

  private void goSomewhereElse() {
    System.out.println("You see a Forest to your NORTH and a Cave to your EAST.");
    System.out.println("Which direction would you like to go?");
  }

  private void stepIntoTheShed() throws InterruptedException {
    System.out.println("\nYou are walking towards the old shed");
    System.out.println("You notice a bloody hand print on the door..");
    System.out.println(
        "You pull the door open to discover a decaying corpse with the stains of blood all over the interior of the Shed.");
    System.out.println(
        "As you examine the corpse, you notice something shiny sticking out of his coat pocket...");
    System.out.println("Would you like to reach into the coat pocket to see what it is?");

    takeShinyThingChoice();
  }

  private void takeShinyThingChoice() throws InterruptedException {
    System.out.println(
        Scene.ANSI_WHITE
            + "- Type "
            + Scene.ANSI_GREEN
            + "\"Y\":"
            + Scene.ANSI_WHITE
            + " to reach and grab the item");
    System.out.println(
        "- Type " + Scene.ANSI_GREEN + "\"N\":" + Scene.ANSI_WHITE + " to walk out of the Shed");
    String choice = playerChoice().toUpperCase();
    if (choice.equals("Y")) {
      grabShinyThingYes();
    } else if (choice.equals("N")) {
      inFrontOfShed();
    } else {
      System.out.println(
          "Wrong input, try typing: "
              + Scene.ANSI_GREEN
              + "Y "
              + Scene.ANSI_WHITE
              + "or "
              + Scene.ANSI_GREEN
              + "N");
      takeShinyThingChoice();
    }
  }

  private void grabShinyThingYes() throws InterruptedException {
    System.out.println("You reach into the coat pocket of the decaying corpse...");
    Thread.sleep(3000);
    System.out.println("You found a " + Scene.ANSI_GREEN + "KEY!");
    System.out.println(Scene.ANSI_WHITE + "Behind the KEY is a note that reads:");
    Thread.sleep(2000);
    System.out.println(
        Scene.ANSI_BLUE
            + "“Hello again, I heard the screams of one of its victims as I came upon this shed in the distance.\n"
            + "I watched in horror as some tall, lanky and shady creature devoured the poor soul trapped inside this old shed.\n"
            + "I felt helpless as I saw it move like the branches of a tree in the wind, swaying and cracking as it progressed back into the forest.\n"
            + "If only there was something I could do to help… I didn’t even know there was anyone else here… \n"
            + "As I investigated further, I found that it was an old man who died, perhaps the owner of the car and hut I saw earlier…\n"
            + "He was holding some kind of key in his hand when he died. I think it may belong to the lockbox I found in this Abandoned Car earlier…”");
    exitShed();
  }

  private void exitShed() throws InterruptedException {
    player.addItemToInventory(Key);
    getItemsInScene().remove(Key);

    Thread.sleep(1000);
    System.out.println(Scene.ANSI_GREEN + "You added the KEY to your inventory.");
    Thread.sleep(2000);
    System.out.println(Scene.ANSI_WHITE + "You exit the Shed and continue your journey.");
    goSomewhereElse();
  }

  private String playerChoice() {
    return choice.nextLine();
  }
}
