package com.slenderman.game;

import java.util.Scanner;

/**
 * Starter instantiates the Game class and begins the game. Nothing but code needed to start the
 * game should be in this class. It should be very small.
 */
public class Starter {

  public static void main(String[] args) throws InterruptedException {
    Game game = new Game();
    new Console(game);
    Scanner scanMe = new Scanner(System.in);
    game.start(scanMe);
  }
}
