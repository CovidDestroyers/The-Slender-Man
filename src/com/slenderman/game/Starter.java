package com.slenderman.game;

import com.slenderman.musicplayer.SimplePlayer;
import java.util.Scanner;






/**
 * Starter instantiates the Game class and begins the game. Nothing but code needed to start the
 * game should be in this class. It should be very small.
 */
public class Starter {

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(){
      public void run(){
        Game game = new Game();
        new Console(game);
        Scanner scanMe = new Scanner(System.in);
        try {
          game.start(scanMe);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Thread thread2 = new Thread(){
      public void run(){
        SimplePlayer player = new SimplePlayer();
      }
    };

    thread1.start();
    thread2.start();
//    Game game = new Game();
//    new Console(game);
//    Scanner scanMe = new Scanner(System.in);
//    game.start(scanMe);
//    SimplePlayer player = new SimplePlayer();


  }


}




