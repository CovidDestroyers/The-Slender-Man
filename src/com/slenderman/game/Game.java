package com.slenderman.game;

import com.slenderman.actors.Player;
import com.slenderman.scenes.AbandonedCar;
import com.slenderman.scenes.Cave;
import com.slenderman.scenes.Field;
import com.slenderman.scenes.Forest;
import com.slenderman.scenes.House;
import com.slenderman.scenes.OutHouse;
import com.slenderman.scenes.Pond;
import com.slenderman.scenes.Scene;
import com.slenderman.scenes.Shed;
import com.slenderman.scenes.Tree;
import com.slenderman.tools.LoseGameTimer;
import java.util.Scanner;

/**
 * Game is the class where we will build out the logic for the actual game. Essentially, this is the
 * place where everything comes together to create the game.
 *
 * <p>This class will be instantiated in the Starter class' Main method to actually start the game
 */
public final class Game {

  // For Unit Testing Purpose //
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

  public void start(Scanner in) throws InterruptedException {
    String userText = "";

    // new LoseGameTimer(1);

    // For Unit Testing purpose
    if (!disableIntroduction) {
      // Introduction.playIntro();
      new LoseGameTimer(10);
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
      } else {
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
    System.out.println(
        "\n"
            + "       __                            \n"
            + " /  | /  | /  |      /  | / /| |  /  \n"
            + "(___|(   |(   |     (   |( ( | | (   \n"
            + "    )|   )|   )     | / )| | | ) |   \n"
            + " __/ |__/ |__/      |/|/ | | |/  _   \n"
            + "                                     \n");
    System.out.println("Thanks for playing!");
    Thread.sleep(5000);
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
