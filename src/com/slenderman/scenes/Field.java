package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.Player;
import com.slenderman.game.Game;

import java.util.*;

public class Field extends Scene {



  //private Map<String, String> scenesAround = new HashMap<>();
  private List<String> grabbedItems = new ArrayList<>();
  private List<Item> itemsInScene = new ArrayList<>();

  Item blade = new Item("blade", this);
  Item note = new Item("note", this);

  private Player player;

  //default constructor
  public Field(Player p){
    setDescription("You have reached am empty field.");
    setSceneName("field");
    this.player = p;


    itemsInScene.add(blade);
    itemsInScene.add(note);
    //non-class array in Java:
    //int[] number = new int[2];
    //int[] numbers = {3,4};
    //numbers[0] = 7;

  }

  public Field(Scene sceneToTheNorth, Scene sceneToTheSouth,
               Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth,
      sceneToTheEast, sceneToTheWest);

    //Add the pre existing items to the List
    setDescription("You have reached am empty field.");
    setSceneName("field");
  }


//  public void setItemsInScene(List<String> itemsInScene){};
//  public <String> List<String> getGrabbedItems(List<String> grabbedItems){
//    List<String> grabbedItems
//  };



  public void enter() throws Exception {

    Scanner in = Game.getScanner();

    String choice;
    System.out.println("\nThere is a field in front of you. You see a flower.");
    System.out.println("What would you like to do?");
    System.out.println(" Type \"0\" : \"Pick up the flower\" " +
      "\n Type \"1\" : \"Step on the flower\"");

    choice = Game.playerChoice(in);

    if (choice.equals("0")) {
      smellIt(in);
    }
    if (choice.equals("1")) {
      footCut(in);
    }
  }

  private void smellIt(Scanner in) throws Exception {
    System.out.println("Do you want to go ahead and smell the flower?");
    System.out.println(" Type \"0\" : \"Yes\" " +
      "\n Type \"1\" : \"No\"");

    String choice = Game.playerChoice(in);

    if (choice.equals("0")) {
      sneeze(in);
    }
    if (choice.equals("1")) {
      //go to the next Tree class

      System.out.println("Which direction would you like to go?");
      System.out.println("Type \"EAST\", \"WEST\", \"NORTH \" or \"SOUTH\"");
    }

  }

  private void sneeze(Scanner in) throws Exception {
    System.out.println("You sneeze loudly and that blew away a piece of paper in the bushes");
    System.out.println("You see a note. Do you want to pick it up?");

    System.out.println(" Type \"0\" : \"Yes\" " +
      "\n Type \"1\" : \"No\"");
    String choice = Game.playerChoice(in);

    if (choice.equals("0")) {
      findBlade(in);
    }
    if (choice.equals("1")) {
      //go to the next Tree class

      System.out.println("Which direction would you like to go?");
      System.out.println("Type \"east\", \"west\", \"north \" or \"south\"");
      String direction_choice = Game.playerChoice(in);
      changeScene(Directions.valueOf(direction_choice));

    }
  }

  private void footCut(Scanner in) throws Exception {
    System.out.println("Ouch! You just got cut on your foot." +
      "Do you want to look at what cut you?");
    System.out.println(" Type \"0\" : \"Yes\" " +
      "\n Type \"1\" : \"No\"");
    String choice = Game.playerChoice(in);
    if (choice.equals("0")){
      findBlade(in);
      }
    else if (choice.equals("1")){
      sneeze(in);
    }
  }

  private void findBlade(Scanner in) throws Exception {

    if (itemsInScene.contains(blade)) {
      System.out.println(
        "You have found a blade. \n Would you like to grab it? " +
          " Type \"0\" : \"Yes\" " +
          "\n Type \"1\" : \"No\"");
      String choice = Game.playerChoice(in);

      int bladeIndex = itemsInScene.indexOf(blade);

      if (choice.equals(bladeIndex)) {

        Item grabbedBlade = itemsInScene.get(bladeIndex);
        System.out.println("You have put " + grabbedBlade + " in your pocket.");
        itemsInScene.remove(bladeIndex);

        player.addItemToInventory(grabbedBlade);
      }
    }

    System.out.println("\nYou look up and see a fork. " +
      "\nOne is a broad way and another is narrow." +
        "\nWhich road would you like to take?");
    System.out.println(" Type \"0\" : \"Broad Way\" " +
      "\n Type \"1\" : \"Narrow Way\"");
    String second_choice = Game.playerChoice(in);

    if (second_choice.equals("0")) {
      sneeze(in);
    } else if (second_choice.equals("1")) {
      System.out.println("Which direction would you like to go?");
      String choice = Game.playerChoice(in);
      if (choice.equals("WEST")) {
        System.out.println("West chosen");
        getSceneToTheWest().enter();
      } else if (choice.equals("EAST")) {
        if(player.getInventory().contains(blade)) {
          getSceneToTheEast().enter();
        }
        else {
          System.out.println("You can't move to the final stage unless you have a blade");
        }
      } else if (choice.equals("NORTH")) {
        getSceneToTheNorth().enter();
      } else if (choice.equals("SOUTH")) {
        getSceneToTheSouth().enter();
      }
    }
  }


}


