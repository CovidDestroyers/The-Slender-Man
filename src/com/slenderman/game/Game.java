package com.slenderman.game;

import com.slenderman.scenes.*;
import com.slenderman.actors.Player;
import com.slenderman.tools.LoseGameTimer;

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

  // For Unit Testing Purpose //
  private boolean disableIntroduction = false;
  private boolean reachedTree = false;
  /////////////////////////////

  private Scene currentScene;
  private Scene aAbandonedCar;
  private Scene aHouse;
  private Scene aOutHouse;
  private Scene aForest;
  private Shed aShed;
  private Scene aTree;
  private Scene aPond;
  private Scene aCave;
  private Scene aField;


  private Player Player;


  public Game() {
    Player = new Player();

    aForest = new Forest();
    aShed = new Shed();
    aAbandonedCar = new AbandonedCar();
    aField = new Field();
    aTree = new Tree();
    aPond = new Pond();
    aCave = new Cave();
    aOutHouse = new OutHouse();
    aHouse = new House();

    aForest.connectSouth(aShed);
    aForest.connectEast(aHouse);

    aAbandonedCar.connectEast(aOutHouse);
    aOutHouse.connectSouth(aPond);
    aHouse.connectEast(aAbandonedCar);
    aHouse.connectSouth(aCave);

    aShed.connectEast(aCave);
    aCave.connectEast(aPond);
    aPond.connectEast(aField);
    aField.connectEast(aTree);
  }



  public void start(Scanner in) throws InterruptedException {
    String userText = "";

    new LoseGameTimer(10);

    // For Unit Testing purpose
    if (!disableIntroduction) {
      Introduction.playIntro();
    }

    currentScene = aForest;
    Player.setCurrentSceneName(currentScene.getSceneName());
    currentScene.enter(in, Player);

    while (true) {
      userText = in.nextLine().toLowerCase().trim();

      if (userText.equals("quit")) {
        System.out.println("Goodbye!");
        break;
      }

      if (userText.startsWith("go ")) {
        currentScene = currentScene.changeScene(userText.substring(3));

        Player.setCurrentSceneName(currentScene.getSceneName());
        Player.changeInvItemsLocation();

        currentScene.enter(in, Player);
      }
      else {
        System.out.println("Unknown command '" + userText + "'.  Try go/take/quit.\n");
      }

      // For Unit Testing purpose
      if (disableIntroduction) {
        if (reachedTree) {
          winMessage();
        }
        reachedTree = (currentScene == aTree);
      }

    }
  }

  private void winMessage() throws InterruptedException {
    Thread.sleep(2000);
    System.out.println("You have killed SlenderMan\n");
    Thread.sleep(5000);
    System.out.println("You Win!");
    System.out.println("Thanks for playing!");
    Thread.sleep(5000);
    System.exit(0);
  }

 /**
  * For Unit Testing purpose
  * */
  public Scene getCurrentScene() {
    return currentScene;
  }
  public void setDisableIntroduction(boolean disableIntroduction) {
    this.disableIntroduction = disableIntroduction;
  }
}
