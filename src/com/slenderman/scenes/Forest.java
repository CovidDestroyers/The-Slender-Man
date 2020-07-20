package com.slenderman.scenes;

import java.util.*;

public class Forest extends Scene{


  public Forest(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
  }

  public Scene goToDifferentScene(){
    System.out.print("\nYou see ");
    System.out.print(getSceneToTheSouth() + " in South direction and ");
    System.out.print(getSceneToTheEast() + " in East direction and ");
    System.out.println("Which direction would you like to go to?");
    System.out.println("- Type \"S\" : go to " + getSceneToTheSouth());
    System.out.println("- Type \"E\" : go to " + getSceneToTheEast());

    boolean askAgain = true;
    Scene result = null;
    do {
      String choice = playerChoice().toUpperCase();
      switch (choice) {
        case "S":
          result = getSceneToTheSouth();
          askAgain = false;
          break;
        case "E":
          result = getSceneToTheEast();
          askAgain = false;
          break;
        default:
          System.out.println(choice + " is invalid. Try again.");
      }
    }while(askAgain);
    return result;
  }

  private String playerChoice(){
    String result = null;

    Scanner choice = new Scanner(System.in);
    result = choice.nextLine();

    return result;
  }





}
