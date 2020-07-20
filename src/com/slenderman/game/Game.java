package com.slenderman.game;

import com.slenderman.scenes.*;
import com.slenderman.actors.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Game is the class where we will build out the logic for the actual game.
 * Essentially, this is the place where everything comes together to create
 * the game.
 *
 * This class will be instantiated in the Starter class' Main method to
 * actually start the game
 *
 */
public class Game {

  private Scene currentScene;
  private Scene AbandonedCar;
  private Scene House;
  private Scene OutHouse;
  private Forest Forest;

  private Player Player;

  public Game() {
    Player = new Player();

    Forest = new Forest();

    AbandonedCar = new AbandonedCar("none", "none", "outhouse", "house");

    House = new House("none", "cave", "outhouse", "forest", true);

    OutHouse = new OutHouse("none", "pond", "none", "abandoned car");

    /**
    * Navigation from Field

    Map<String, String> scenesAroundField = new HashMap<>();
    scenesAroundField.put("WEST", "Pond");
    scenesAroundField.put("EAST", "Tree");
    scenesAroundField.put("NORTH", null);
    scenesAroundField.put("SOUTH", null);
     */
    //Field aField = new Field(scenesAroundField);


    //using default constructor to set directions of tree to (null, null, null, null)
    Tree aTree = new Tree();
    Pond aPond = new Pond();
    Cave aCave = new Cave();
    OutHouse aOutHouse = new OutHouse();


    Field aField = new Field(null, null,
      aTree, aPond);

    //after Field has used a direction-empty Tree, actually telling tree what is in the west of tree
    aTree.setSceneToTheWest(aField);
    aPond.setSceneToTheEast(aField);
    aPond.setSceneToTheWest(aCave);
    aPond.setSceneToTheNorth(aOutHouse);

    aField.enter();



    /**
     * Navigation from Field

    Map<String, String> scenesAroundTree = new HashMap<>();
    scenesAroundTree.put("WEST", "Field");
    scenesAroundTree.put("EAST", "null");
    scenesAroundTree.put("NORTH", null);
    scenesAroundTree.put("SOUTH", null);
    */

    // TODO: Change to Forest
    currentScene = House;

  }


  /**
  public void start(Scanner in) throws InterruptedException {
    Introduction.playIntro();

    String userText = "go";

    while (!userText.equals("quit")) {
    // while (Player.state.equals("alive")) {
      System.out.println("Give me something good:");
      userText = in.nextLine().toLowerCase().trim();

      if (userText.equals("quit")) {
        System.out.println("Goodbye!");
      }

      System.out.printf("Hey you pressed on some keys!\n%s\n", userText);
    }

  }
   */

}
