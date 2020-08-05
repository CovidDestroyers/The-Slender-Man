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
import java.text.DecimalFormat;
import java.util.*;

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
  public SlenderManProgression slenderManProgression;
  public static boolean isPlayerAlive;

  public Game() {
    Player = new Player();
    slenderManProgression = new SlenderManProgression(1);
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
      new SlenderManProgression(1);
      new SlenderManProgression(2);
      new SlenderManProgression(3);
      new SlenderManProgression(4);
      new SlenderManProgression(5);
      new SlenderManProgression(6);
      new SlenderManProgression(7);
      new SlenderManProgression(8);
      new SlenderManProgression(9);
      new SlenderManProgression(10);
    }

    currentScene = aForest;
    Player.setCurrentSceneName(currentScene.getSceneName());
    currentScene.enter(in, Player);
    start(in);
  }


  public void startTheGame(Scanner in) throws Exception {
    gameInitializer(in);
    start(in);
  }

  void start(Scanner in) throws Exception {
    String userText = "";
    String[] words = null;

    if (!SlenderMan.isGameDone) {
      slenderManProgressionStatus(Player.getInventory().size());
      userText = in.nextLine().toLowerCase();
      words = userText.split("\\W+");
    } else {
      currentScene = LoseGameScene;
      Player.setCurrentSceneName(currentScene.getSceneName());
      Player.changeInvItemsLocation();
      currentScene.enter(in, Player);
    }

    assert Objects.requireNonNull(words)[0] != null;
    assert Objects.requireNonNull(words)[1] != null;

    if (Commands.getGoCommands().contains(words[0])) {
      if (Commands.getDirectionCommands().contains(words[1])) {
        playerMovement(in, words[1]);
      } else {
        System.out.println("Incorrect Direction");
      }
    } else if (Commands.getQuitCommands().contains(words[0])) {
      quitGame();
    } else if (Commands.getPauseCommands().contains(words[0])) {
      pauseGame(in, Integer.parseInt(words[1]));
    } else {
      System.out.println("Unknown Command of: " + userText);
      System.out.println("Try Another Command.");
    }

    winCondition();
  }

  private void playerMovement(Scanner in, String direction) throws Exception {
    currentScene = currentScene.changeScene(direction);
    Player.setCurrentSceneName(currentScene.getSceneName());
    Player.changeInvItemsLocation();
    currentScene.enter(in, Player);
    start(in);
  }

  private void slenderManProgressionStatus(int inventorySize) throws InterruptedException {
    Random random = new Random();
    double finalResult = Double.parseDouble(new DecimalFormat("##.##")
      .format((inventorySize * 5) + (SlenderMan.getCompletions() * 5)
      + random.nextFloat()));

    if (finalResult >= 100) {
      SlenderMan.killPlayer();
    }

    System.out.println("\nThe SlenderMan notices you're progressing...");
    System.out.println("You have a " + finalResult + "% chance of him attacking you.\n");
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

  private void pauseGame(Scanner in, int time) throws Exception {
    int delayCounter = time;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    System.out.println("Pausing the game for: " + time + " seconds.");
    System.out.println("\n");

    for (int i = 0; i < time; i++) {
      System.out.println("Resuming the game in " + delayCounter-- + " seconds.");
      Thread.sleep(1000);

      if (delayCounter <= 10) {
        for (int k = 0; k < 10; k++) {
          toolkit.beep();
        }
      }

      if (delayCounter == 0) {
        System.out.println("\n");
        System.out.println("Resuming Game Now!");
        toolkit.beep();
        Thread.sleep(1500);

        for (int h = 0; h < 50; h++) {
          System.out.println("\n");
        }
      }
    }

    Player.setCurrentSceneName(currentScene.getSceneName());
    Player.changeInvItemsLocation();
    currentScene.enter(in, Player);
    start(in);
  }

  private void quitGame() {
    System.out.println("Goodbye, " + Introduction.getPlayerName() + "!");
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
