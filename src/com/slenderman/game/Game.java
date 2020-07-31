package com.slenderman.game;

import com.slenderman.actors.Player;
import com.slenderman.actors.SlenderMan;
import com.slenderman.color.Color;
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


  // For Unit Testing Purpose //
  private boolean disableIntroduction = false;
  private boolean reachedTree = false;

  private Scene currentScene;
  private final Scene aHouse;
  private final Scene aForest;
  private final Shed aShed;
  private final Scene aTree;
  private final Scene aPond;
  private final Scene aCave;
  private final Scene aField;
  private final Scene LoseGameScene;

  public static boolean isPlayerAlive;

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
    LoseGameScene = new LoseGameScene();

    aForest.connectSouth(aShed);
    aForest.connectEast(aHouse);
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

  public void start(Scanner in) throws Exception {
    String userText = "";

    // For Unit Testing purpose
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

    while (true) {
      if (!SlenderMan.isGameDone) {
        userText = in.nextLine().toLowerCase().trim();
      } else {
        currentScene = LoseGameScene;

        Player.setCurrentSceneName(currentScene.getSceneName());
        Player.changeInvItemsLocation();

        currentScene.enter(in, Player);
      }

      if (userText.equals("quit")) {
        System.out.println("Goodbye!");
        break;
      }

      else if (userText.startsWith("pause ")) {
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
      }

      else if (userText.startsWith("go ")) {
        currentScene = currentScene.changeScene(userText.substring(3));

        Player.setCurrentSceneName(currentScene.getSceneName());
        Player.changeInvItemsLocation();

        currentScene.enter(in, Player);
      }

      else {
        System.out.println("Unknown command '" + userText + "'.  Try go/quit.\n");
      }

      // For Unit Testing purpose
      if (disableIntroduction) {
        if (reachedTree) {
          winMessage();
        }
        reachedTree = (currentScene == aTree);
      }
      // Not unit testing mode
      else {
        if (currentScene == aTree) {
          if (Player.getNumItemsPlayerHas() >= Player.TOTAL_NUM_ITEMS_TO_FINISH_GAME) {
            winMessage();
          }
        }
      }
    }
  }

  private void winMessage() throws InterruptedException {
    int quickest = 2000;
    int middle = 3000;
    int slow = 4000;
    int slowest = 5000;

    Thread.sleep(quickest);
    System.out.println("You walk slowly towards a lonely tree in the middle of a field...\n");
    Thread.sleep(middle);
    System.out.println("Something tells you to carve an X on the tree...\n");
    Thread.sleep(middle);
    System.out.println("You take the blade, and stab it into the tree...\n");
    Thread.sleep(middle);
    System.out.println(
        "You breathe heavily as you begin to make the shape of an X on the tree...\n");
    Thread.sleep(middle);
    System.out.println("As you finish, you take a couple steps back...\n");
    Thread.sleep(middle);
    System.out.println("You begin to hear an overpowering screeching sound...\n");
    Thread.sleep(middle);
    System.out.println("You see something emerge from the shadows...\n");
    Thread.sleep(middle);
    System.out.println("The creature cracks and shifts around as it approaches you...\n");
    Thread.sleep(middle);
    System.out.println("The screeching becomes unbearable as you begin to lose your senses...\n");
    Thread.sleep(middle);
    System.out.println(
        "You reach out for the blade and hold it front of you as the creature charges...\n");
    Thread.sleep(middle);
    System.out.println("...\n");
    Thread.sleep(slow);
    System.out.println("...\n");
    Thread.sleep(slowest);
    System.out.println("You have killed SlenderMan!\n");
    Thread.sleep(middle);
    System.out.println("You let out a sigh of relief as the sun rises over the thick woods.\n");
    System.out.println(
        "You see a possible exit in the distance, and begin your journey to freedom...\n");
    Thread.sleep(slowest);
    System.out.println(
        "\n"
            + "       __                            \n"
            + " /  | /  | /  |      /  | / /| |  /  \n"
            + "(___|(   |(   |     (   |( ( | | (   \n"
            + "    )|   )|   )     | / )| | | ) |   \n"
            + " __/ |__/ |__/      |/|/ | | |/  _   \n"
            + "                                     \n");
    System.out.println("Thanks for playing!");
    Thread.sleep(9000);
    System.exit(1);
  }

  /** For Unit Testing purpose */
  public Scene getCurrentScene() {
    return currentScene;
  }

  public void setDisableIntroduction(boolean disableIntroduction) {
    this.disableIntroduction = disableIntroduction;
  }
}
