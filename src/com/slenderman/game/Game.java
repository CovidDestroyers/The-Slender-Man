package com.slenderman.game;

import com.slenderman.actors.Player;
import com.slenderman.actors.SlenderMan;
import com.slenderman.color.Color;
import com.slenderman.commands.Commands;
import com.slenderman.scenes.Cave;
import com.slenderman.scenes.Field;
import com.slenderman.scenes.Forest;
import com.slenderman.scenes.House;
import com.slenderman.scenes.Introduction;
import com.slenderman.scenes.LoseGameScene;
import com.slenderman.scenes.Pond;
import com.slenderman.scenes.Scene;
import com.slenderman.scenes.Shed;
import com.slenderman.scenes.Tree;
import com.slenderman.tools.*;

import java.awt.*;
import java.util.Scanner;
import java.util.Timer;

/**
 * Game is the class where we will build out the logic for the actual game. Essentially, this is the
 * place where everything comes together to create the game.
 *
 * This class will be instantiated in the Starter class' Main method to actually start the game
 */

public final class Game {
  private WinMessage winMessage = new WinMessage();
  private boolean disableIntroduction = false;
  private boolean reachedTree = false;
  private Scene currentScene;
  private final Scene aForest;
  private final Scene aTree;
  private final Scene LoseGameScene;
  private final Player Player;
  public static boolean isPlayerAlive;

  public Game() {
    Player = new Player();
    Shed aShed = new Shed();
    aTree = new Tree();
    Scene aPond = new Pond();
    Scene aCave = new Cave();
    Scene aField = new Field();
    Scene aHouse = new House();
    aForest = new Forest();
    LoseGameScene = new LoseGameScene();

    aForest.connectSouth(aShed);
    aForest.connectEast(aHouse);
    aHouse.connectSouth(aCave);
    aShed.connectEast(aCave);
    aCave.connectEast(aPond);
    aPond.connectEast(aField);
    aField.connectEast(aTree);
  }

  public void startTheGame(Scanner in) throws Exception {
    gameInitializer(in);
    start(in);
  }

  void start(Scanner in) throws Exception {
    String userText = "";
    String[] words = userText.split(" ");

    if (!SlenderMan.isGameDone) {
      userText = in.nextLine().toLowerCase();
    } else {
        currentScene = LoseGameScene;
        Player.setCurrentSceneName(currentScene.getSceneName());
        Player.changeInvItemsLocation();
        currentScene.enter(in, Player);
    }

    // TODO: Need to update with multiple word parsing.
    // TODO: Need to update go/pause with synonyms.
    for (String word : words) {
      if (userText.startsWith("go ")){
        playerMovement(in, userText);
      } else if (Commands.getQuitCommands().contains(userText)) {
        quitGame();
      } else if (userText.startsWith("pause ")) {
        pauseGame(in, userText);
      } else {
        System.out.println("Unknown Command of: " + userText);
        System.out.println("Try Another Command");
      }
    }

    winCondition();
  }

  private void playerMovement(Scanner in, String userText) throws Exception {
    if (userText.startsWith("go ")) {
      currentScene = currentScene.changeScene(userText.substring(3));
      Player.setCurrentSceneName(currentScene.getSceneName());
      Player.changeInvItemsLocation();
      currentScene.enter(in, Player);
      start(in);
    }
  }

  private void winCondition() throws InterruptedException {
    // For Unit Testing purpose
    if (disableIntroduction) {
      if (reachedTree) {
        winMessage.winMessage();
      }
      reachedTree = (currentScene == aTree);
    }
    // Not unit testing mode
    else {
      if (currentScene == aTree) {
        if (Player.getNumItemsPlayerHas() >= Player.TOTAL_NUM_ITEMS_TO_FINISH_GAME) {
          winMessage.winMessage();
        }
      }
    }
  }

  private void gameInitializer(Scanner in) throws Exception {
    if (!disableIntroduction) {
      Introduction.playIntro();
      new LoseGameTimer(10);
      new OneMinuteTimer(1);
      new OneMinuteTimer(2);
      new OneMinuteTimer(3);
      new OneMinuteTimer(4);
      new OneMinuteTimer(5);
      new OneMinuteTimer(6);
      new OneMinuteTimer(7);
      new OneMinuteTimer(8);
      new OneMinuteTimer(9);
    }

    currentScene = aForest;
    Player.setCurrentSceneName(currentScene.getSceneName());
    currentScene.enter(in, Player);
    start(in);
  }

  private void pauseGame(Scanner in, String userText) throws Exception {
    if (userText.startsWith("pause ")) {
      int delay = Integer.parseInt(userText.substring(6));
      int delayCounter = delay;
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      System.out.println("Pausing the game for: " + delay + " seconds.");
      System.out.println("\b");

      for (int i = 0; i < delay; i++) {
        System.out.println("Resuming the game in " + delayCounter-- + " seconds.");
        Thread.sleep(1000);

        if (delayCounter <= 10) {
          for (int k = 0; k < 10; k++) {
            toolkit.beep();
          }
        }

        if (delayCounter == 0) {
          System.out.println("\b");
          System.out.println("Resuming Game Now!");
          toolkit.beep();
          Thread.sleep(1500);

          for (int h = 0; h < 50; h++) {
            System.out.println("\b");
          }
        }
      }

      Player.setCurrentSceneName(currentScene.getSceneName());
      Player.changeInvItemsLocation();
      currentScene.enter(in, Player);
      start(in);
    }
  }

  private void quitGame() {
    System.out.println("Goodbye!");
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
