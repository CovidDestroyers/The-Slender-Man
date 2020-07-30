package com.slenderman.game;

import com.slenderman.actors.SlenderMan;
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
        while(!SlenderMan.isGameDone) {
          SimplePlayer player = new SimplePlayer("Paranormal_Lullaby.mp3");
        }
      }
    };

    Thread thread3 = new Thread(){
      public void run(){
        try {
          while (!SlenderMan.isGameDone) {
            sleep(60000);
            SimplePlayer player = new SimplePlayer("Scream.mp3");
          }
          } catch(InterruptedException e){
            e.printStackTrace();
          }
      }
    };

    thread1.start();
    thread2.start();
    thread3.start();
  }
}




