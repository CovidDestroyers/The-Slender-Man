package com.slenderman.game;

import com.slenderman.actors.Item;
import com.slenderman.actors.Player;
import com.slenderman.scenes.*;
import com.slenderman.tools.LoseGameTimer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Game is the class where we will build out the logic for the actual game. Essentially, this is the
 * place where everything comes together to create the game.
 *
 * <p>This class will be instantiated in the Starter class' Main method to actually start the game
 */
public class Game {
  private boolean disableIntroduction = false;
  private boolean reachedTree = false;

  private Scene currentScene;
  private final Scene aAbandonedCar;
  private final Scene aHouse;
  private final Scene aOutHouse;
  private final Scene aForest;
  private final Shed aShed;
  private final Scene aTree;
  private final Scene aPond;
  private final Scene aCave;
  private final Scene aField;

  private final Player Player;

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Game() {
    Player = new Player();
    aShed = new Shed();
    aTree = new Tree();
    aPond = new Pond();
    aCave = new Cave();
    aField = new Field();
    aHouse = new House();
    aForest = new Forest();
    aOutHouse = new OutHouse();
    aAbandonedCar = new AbandonedCar();

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

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

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
      // Not unit testing mode
      else{
        if(currentScene == aTree){
          if (Player.getNumItemsPlayerHas() >= Player.TOTAL_NUM_ITEMS_TO_FINISH_GAME){
            winMessage();
          }
        }
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

  /** For Unit Testing purpose */
  public Scene getCurrentScene() {
    return currentScene;
  }

  public void setDisableIntroduction(boolean disableIntroduction) {
    this.disableIntroduction = disableIntroduction;
  }
}
