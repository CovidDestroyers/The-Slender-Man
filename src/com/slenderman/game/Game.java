package com.slenderman.game;

import com.slenderman.scenes.*;
import com.slenderman.actors.Player;

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

    ((com.slenderman.scenes.House) House).playerHasKey(Player);

    OutHouse = new OutHouse("none", "pond", "none", "abandoned car");

    // TODO: Change to Forest
    currentScene = House;

  }


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


}
