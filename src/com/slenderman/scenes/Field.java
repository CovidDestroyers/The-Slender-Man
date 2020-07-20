package com.slenderman.scenes;

import java.util.*;

public class Field extends Scene {

  //private Map<String, String> scenesAround = new HashMap<>();
  private List<String> grabbedItems = new ArrayList<>();
  private List<String> itemsInScene = new ArrayList<>();





  public Field(Scene sceneToTheNorth, Scene sceneToTheSouth,
               Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth,
      sceneToTheEast, sceneToTheWest);

    //Add the pre existing items to the List
    itemsInScene.add("blade");
  }

//  public void setItemsInScene(List<String> itemsInScene){};
//  public <String> List<String> getGrabbedItems(List<String> grabbedItems){
//    List<String> grabbedItems
//  };

  public void enter() {
    String choice;
    System.out.println("\nThere is a field in front of you. You see a flower.");
    System.out.println("What would you like to do?");
    System.out.println(" Type \"0\" : \"Pick up the flower\" " +
      "\n Type \"1\" : \"Step on the flower\"");

    choice = playerChoice();

    if (choice.equals("0")) {
      smellIt();
    }
    if (choice.equals("1")) {
      footCut();
    }
  }

  private void smellIt() {
    System.out.println("Do you want to go ahead and smell the flower?");
    String choice = playerChoice();
    System.out.println(" Type \"0\" : \"Yes\" " +
      "\n Type \"1\" : \"No\"");

    if (choice.equals("0")) {
      sneeze();
    }
    if (choice.equals("1")) {
      //go to the next Tree class

      System.out.println("Which direction would you like to go?");
      choice = playerChoice();
      if (choice.equals("WEST")) {
        System.out.println("West chosen");
        getSceneToTheWest().enter();
      } else if (choice.equals("EAST")) {
        getSceneToTheEast().enter();
      } else if (choice.equals("NORTH")) {
        getSceneToTheNorth().enter();
      } else if (choice.equals("SOUTH")) {
        getSceneToTheSouth().enter();
      }
    }

  }

  private void sneeze() {
    System.out.println("You sneeze loudly and that blew away a piece of paper in the bushes");
    System.out.println("You see a note. Do you want to pick it up?");

    String choice = playerChoice();

    System.out.println(" Type \"0\" : \"Yes\" " +
      "\n Type \"1\" : \"No\"");

    if (choice.equals("0")) {
      findBlade();
    }
    if (choice.equals("1")) {
      //go to the next Tree class

      System.out.println("Which direction would you like to go?");
      choice = playerChoice();
      if (choice.equals("WEST")) {
        System.out.println("West chosen");
        getSceneToTheWest().enter();
      } else if (choice.equals("EAST")) {
        getSceneToTheEast().enter();
      } else if (choice.equals("NORTH")) {
        getSceneToTheNorth().enter();
      } else if (choice.equals("SOUTH")) {
        getSceneToTheSouth().enter();
      }

    }
  }

  private void footCut(){
    System.out.println("Do you want to look at what cut you?");
    System.out.println(" Type \"0\" : \"Yes\" " +
      "\n Type \"1\" : \"No\"");
    String choice = playerChoice();
    if (choice.equals("0")){
      findBlade();
      }
    else if (choice.equals("1")){
      sneeze();
    }
  }

  private void findBlade() {
    String choice = playerChoice();
    System.out.println(
      "You have found a blade. \n Would you like to grab it? "
      " Type \"0\" : \"Yes\" " +
        "\n Type \"1\" : \"No\"");
    choice = playerChoice();
    if (choice.equals("0")) {
      grabbedItems.add(itemsInScene.get(0));
      itemsInScene.remove(0);
    }

    System.out.println("\nYou look up and see a fork. " +
      "\nOne is a broad way and another is narrow." +
        "\nWhich road would you like to take?");
    System.out.println(" Type \"0\" : \"Broad Way\" " +
      "\n Type \"1\" : \"Narrow Way\"");
    choice = playerChoice();

    if (choice.equals("0")) {
      sneeze();
    } else if (choice.equals("1")) {
      System.out.println("Which direction would you like to go?");
      choice = playerChoice();
      if (choice.equals("WEST")) {
        System.out.println("West chosen");
        getSceneToTheWest().enter();
      } else if (choice.equals("EAST")) {
        getSceneToTheEast().enter();
      } else if (choice.equals("NORTH")) {
        getSceneToTheNorth().enter();
      } else if (choice.equals("SOUTH")) {
        getSceneToTheSouth().enter();
      }
    }
  }

  private String playerChoice() {
    String result = null;

    Scanner choice = new Scanner(System.in);
    result = choice.nextLine();

    return result;
  }

}


