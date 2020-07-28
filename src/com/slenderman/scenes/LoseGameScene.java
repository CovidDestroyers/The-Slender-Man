//package com.slenderman.scenes;
//
//import com.slenderman.actors.Player;
//import com.slenderman.actors.SlenderMan;
//import com.slenderman.game.Game;
//import com.slenderman.game.Starter;
//
//import java.util.Scanner;
//
//public class LoseGameScene extends Scene {
//  private Scanner choice;
//
//
//
//  @Override
//  public void enter(Scanner in, Player player) throws InterruptedException {
//    player.setCurrentSceneName(this.getSceneName());
//    choice = in;
//    loseGame();
//  }
//
//  public void loseGame() throws InterruptedException {
//    SlenderMan.killPlayer();
//    restartOrQuit();
//
//  }
//
//  public void restartOrQuit() throws InterruptedException {
//    Thread.sleep(2000);
//    System.out.println("Would you like to play again?");
//    System.out.println("- Type \"Y\": to play again.");
//    System.out.println("- Type \"N\": to quit.");
//    String choice = playerChoice().toUpperCase();
//    if (choice.equals("Y")){
//      Starter.restart();
//    }
//    else if(choice.equals("N")){
//      System.exit(0);
//    }
//    else{
//      System.out.println("Wrong input, try typing: Y or N");
//      restartOrQuit();
//    }
//  }
//
//  private String playerChoice(){
//    return choice.nextLine();
//  }
//}
