package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Field extends Scene {

  private Scanner scanner;

  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("field");

  private final Item Blade = ItemDirector.findThisItem("blade", itemsInThisScene);

  // default constructor
  public Field() {
    setDescription("You have reached am empty field.");
    setSceneName("field");
    setItemsInScene(itemsInThisScene);
  }

  public Field(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    setDescription("You have reached am empty field.");
    setSceneName("field");
    setItemsInScene(itemsInThisScene);
  }

  public void enter(Scanner in, Player player) throws InterruptedException {
    player.setCurrentSceneName(this.getSceneName());
    scanner = in;
    String choice;
    System.out.println("\nThere is a field in front of you. You see a flower.");
    System.out.println("What would you like to do?");
    System.out.println(
        " Type \"0\" : \"Pick up the flower\" " + "\n Type \"1\" : \"Step on the flower\"");

    choice = playerChoice();

    if (choice.equals("0")) {
      smellIt(in, player);
    }
    if (choice.equals("1")) {
      footCut(in, player);
    }
  }

  private void smellIt(Scanner in, Player player) throws InterruptedException {
    System.out.println("Do you want to go ahead and smell the flower?");
    System.out.println(" Type \"0\" : \"Yes\" " + "\n Type \"1\" : \"No\"");
    String choice = playerChoice();

    if (choice.equals("0")) {
      sneeze(in, player);
    }
    if (choice.equals("1")) {
      // go to the next Tree class

      System.out.println("Which direction would you like to go?");
      System.out.println("Type \"EAST\", \"WEST\", \"NORTH \" or \"SOUTH\"");
      //      choice = playerChoice();
      //      if (choice.equals("WEST")) {
      //        System.out.println("West chosen");
      //        getSceneToTheWest().enter(in, player);
      //      } else if (choice.equals("EAST")) {
      //        getSceneToTheEast().enter(in, player);
      //      } else if (choice.equals("NORTH")) {
      //        getSceneToTheNorth().enter(in, player);
      //      } else if (choice.equals("SOUTH")) {
      //        getSceneToTheSouth().enter(in, player);
      //      }
    }
  }

  private void sneeze(Scanner in, Player player) throws InterruptedException {
    System.out.println("You sneeze loudly and that blew away a piece of paper in the bushes");
    System.out.println("You see a note. Do you want to pick it up?");

    System.out.println(" Type \"0\" : \"Yes\" " + "\n Type \"1\" : \"No\"");
    String choice = playerChoice();

    if (choice.equals("0")) {
      findBlade(in, player);
    }
    if (choice.equals("1")) {
      // go to the next Tree class

      System.out.println("Which direction would you like to go?");
      System.out.println("Type \"east\", \"west\", \"north \" or \"south\"");
      choice = playerChoice();
      changeScene(choice);
    }
  }

  private void footCut(Scanner in, Player player) throws InterruptedException {
    System.out.println(
        "Ouch! You just got cut on your foot." + "Do you want to look at what cut you?");
    System.out.println(" Type \"0\" : \"Yes\" " + "\n Type \"1\" : \"No\"");
    String choice = playerChoice();
    if (choice.equals("0")) {
      findBlade(in, player);
    } else if (choice.equals("1")) {
      sneeze(in, player);
    }
  }

  private void findBlade(Scanner in, Player player) throws InterruptedException {
    System.out.println(
        "You have found a blade. \n Would you like to grab it? "
            + " Type \"0\" : \"Yes\" "
            + "\n Type \"1\" : \"No\"");
    String choice = playerChoice();

    if (choice.equals("0")) {
      player.addItemToInventory(Blade);

      System.out.println("You have put the blade in your pocket.");

      getItemsInScene().remove(Blade);
    }

    System.out.println(
        "\nYou look up and see a fork. "
            + "\nOne is a broad way and another is narrow."
            + "\nWhich road would you like to take?");
    System.out.println(" Type \"0\" : \"Broad Way\" " + "\n Type \"1\" : \"Narrow Way\"");
    choice = playerChoice();

    if (choice.equals("0")) {
      sneeze(in, player);
    } else if (choice.equals("1")) {
      System.out.println("Which direction would you like to go?");
      //      choice = playerChoice();
      //      if (choice.equals("WEST")) {
      //        System.out.println("West chosen");
      //        getSceneToTheWest().enter(in, player);
      //      } else if (choice.equals("EAST")) {
      //        getSceneToTheEast().enter(in, player);
      //      } else if (choice.equals("NORTH")) {
      //        getSceneToTheNorth().enter(in, player);
      //      } else if (choice.equals("SOUTH")) {
      //        getSceneToTheSouth().enter(in, player);
      //      }
    }
  }

  private String playerChoice() {
    return scanner.nextLine();
  }
}
