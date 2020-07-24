package com.slenderman.scenes;

import com.slenderman.actors.Player;
import com.slenderman.game.Game;

import java.util.Scanner;

public class Shed extends Scene{
  //default constructor
  public Shed(){
    setSceneName("shed");
  }
  public Shed(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
    setSceneName("shed");
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    player.setCurrentSceneName(this.getSceneName());
    inFrontOfShed();
  }

  private void inFrontOfShed() throws InterruptedException {
    String choice;
    System.out.println("\nThere is an old Shed in front of you.");
    System.out.println("What would you like to do?");
    System.out.println("\n");
    System.out.println(" Type \"0\" : \"Go into the Shed\" " +
      "\n Type \"1\" : \"Go somewhere else\"");

    choice = playerChoice();
    if (choice.equals("0")){
      stepIntoTheShed();
    }
    else if(choice.equals("1")) {
      goSomewhereElse();
    }
    else {
      System.out.println("Wrong input, try entering 0 or 1.");
      inFrontOfShed();
    }
  }

  private void goSomewhereElse() {
    System.out.println("You see a Forest to your NORTH and a Cave to your EAST.");
    System.out.println("Which direction would you like to go?");
    System.out.println("\n");
  }

  private void stepIntoTheShed() throws InterruptedException {
    System.out.println("\nYou are walking towards the old shed");
    System.out.println("You notice a bloody hand print on the door..");
    System.out.println("You pull the door open to discover a decaying corpse with the stains of blood all over the interior of the Shed.");
    System.out.println("As you examine the corpse, you notice something shiny sticking out of his coat pocket...");
    System.out.println("Would you like to reach into the coat pocket to see what it is?");
    System.out.println("\n");

    takeShinyThingChoice();
  }

  private void takeShinyThingChoice() throws InterruptedException {
    System.out.println("- Type \"Y\": to reach and grab the item");
    System.out.println("- Type \"N\": to walk out of the Shed");
    String choice = playerChoice().toUpperCase();
    if (choice.equals("Y")){
      grabShinyThingYes();
    }
    else if(choice.equals("N")){
      inFrontOfShed();
    }
    else{
      System.out.println("Wrong input, try typing: Y or N");
      takeShinyThingChoice();
    }
  }

  private void grabShinyThingYes() throws InterruptedException {
    System.out.println();
    System.out.println("You reach into the coat pocket of the decaying corpse...");
    Thread.sleep(3000);
    System.out.println("You found a KEY!");
    System.out.println("Behind the KEY is a note that reads:");
    System.out.println("\n");
    Thread.sleep(2000);
    System.out.println(" \"Hello again, I heard the screams of one of its victims as I came upon this shed in the distance.\n" +
      "I watched in horror as some tall, lanky and shady creature devoured the poor soul trapped inside this old shed.\n" +
      "I felt helpless as I saw it move like the branches of a tree in the wind, swaying and cracking as it progressed back into the forest.\n" +
      "If only there was something I could do to help... I didn\'t even know there was anyone else here... \n" +
      "As I investigated further, I found that it was an old man who died, perhaps the owner of the car and hut I saw earlier...\n" +
      "He was holding some kind of key in his hand when he died. I think it may belong to the lockbox I found in this Abandoned Car earlier...\"");
    System.out.println("\n");
    exitShed();
  }

  private void exitShed() throws InterruptedException {
    Thread.sleep(10000);
    System.out.println("You added the KEY to your inventory.");
    System.out.println("\n");
    Thread.sleep(2000);
    System.out.println("You exit the Shed and continue your journey.");
    goSomewhereElse();

  }



  private String playerChoice(){
    String result = null;

    Scanner choice = new Scanner(System.in);
    result = choice.nextLine();

    return result;
  }

}

