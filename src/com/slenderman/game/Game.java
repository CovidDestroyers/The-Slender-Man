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
  private Scene Forest;
  private Shed Shed;
  private Scene Tree;

  private Player Player;


  public Game() {
    Player = new Player();


  }



  public void start(Scanner in) throws InterruptedException {
    Introduction.playIntro();
    currentScene = Forest;
    Forest.setSceneToTheEast(House);
    currentScene.getDescription();


    String userText = "go";

    while (!userText.equals("quit")) {
      // while (Player.state.equals("alive")) {
      System.out.println("Give me something good:");
      userText = in.nextLine().toLowerCase().trim();
      if (userText.equals("quit")) {
        System.out.println("Goodbye!");
        break;
      } else if (userText.startsWith("go ")) {
        currentScene = currentScene.changeScene(userText.substring(3));
        currentScene.getDescription();
      } else {
        System.out.println("Unknown command '" + userText + "'.  Try go/take/quit.\n");
      }

      System.out.printf("Hey you pressed on some keys!\n%s\n", userText);
    }
    if (currentScene == Tree) {
      Thread.sleep(2000);
      System.out.println("You have killed SlenderMan\n");
      Thread.sleep(5000);
      System.out.println("You Win!");
      System.out.println("Thanks for playing!");
      Thread.sleep(5000);
      System.exit(0);

    }
  }

}
