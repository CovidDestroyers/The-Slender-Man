package com.slenderman.game;

import com.slenderman.actors.Player;
import com.slenderman.actors.SlenderMan;
import com.slenderman.musicplayer.SimplePlayer;
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
import com.slenderman.inputcommands.InputCommands;

import java.util.Scanner;

/**
 * Game is the class where we will build out the logic for the actual game. Essentially, this is the
 * place where everything comes together to create the game.
 *
 * This class will be instantiated in the Starter class' Main method to actually start the game
 */
public final class Game{
  String userText = "";

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
  //  private int sleep = 2000;
  public static boolean isPlayerAlive;

  private final Player Player;
  private final WinGame winGame = new WinGame();


  public static int gameDifficultyTimer;





  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Game(){
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
//TODO find better way to enable/disable music, when enabled it doesnt let you work the game, though disabled functions correctly

  public void gameOptions(Scanner in) throws InterruptedException {
    gameDifficulty(in);
    System.out.println("Would you like music enabled or disabled?");
    userText = in.nextLine();
    if("enabled".equalsIgnoreCase(userText) || "e".equalsIgnoreCase(userText)){
      thread2.start();
      start(in);
    }
    if("disabled".equalsIgnoreCase(userText) || "d".equalsIgnoreCase(userText)){
      start(in);
    }
    else{
      gameOptions(in);
    }
  }
  //Gives user option to dictate how long game lasts by setting gameDifficultyTimer to specific value;
  public void gameDifficulty(Scanner in){
    System.out.println("What level of difficulty would you like?");
    System.out.println(" Easy\n Medium\n Hard");
    userText = in.nextLine();
    if("easy".equalsIgnoreCase(userText) || "e".equalsIgnoreCase(userText)){
      gameDifficultyTimer = 10;
    }
    else if("medium".equalsIgnoreCase(userText) || "m".equalsIgnoreCase(userText)){
      gameDifficultyTimer = 7;
    }
    else if("hard".equalsIgnoreCase(userText) || "h".equalsIgnoreCase(userText)){
      gameDifficultyTimer = 5;
    }
    else{
      gameDifficulty(in);
    }
  }

  public void start(Scanner in) throws InterruptedException {
    // For Unit Testing purpose
    if (!disableIntroduction) {
      Introduction.playIntro();
      new LoseGameTimer().gameTimer(gameDifficultyTimer);
      new OneMinuteTimer().startOneTimer();
    }
    currentScene = aForest;
    Player.setCurrentSceneName(currentScene.getSceneName());
    currentScene.enter(in, Player);
    while (true) {
      String[] userInput = null;
      if (!SlenderMan.isGameDone) {
        userText = in.nextLine().toLowerCase().trim();
        //Do a global search for non-word characters in a string (w3schools.com)
        userInput = userText.split("\\W");
      } else {
        currentScene = LoseGameScene;
        Player.setCurrentSceneName(currentScene.getSceneName());
        Player.changeInvItemsLocation();
        currentScene.enter(in, Player);
      }
      assert userInput != null;
      userInputCommands(userInput, in);
      if(!InputCommands.getPlayerMovement().contains(userInput[0]))
      {
        System.out.println("Unknown command '" + userText + "'.  Try movement + direction. Or Quit\n");
      }
      winCondition();
    }
  }


  /** For Unit Testing purpose */
  public Scene getCurrentScene() {
    return currentScene;
  }

  public com.slenderman.actors.Player getPlayer() {
    return Player;
  }

  public void setDisableIntroduction(boolean disableIntroduction) {
    this.disableIntroduction = disableIntroduction;
  }

  public void userInputCommands(String[] userInput, Scanner in){
    try {
      if (InputCommands.getPlayerMovement().contains(userInput[0])) {
        if (InputCommands.getPlayerDirection().contains(userInput[1])) {
          System.out.println(userInput[1]);
          currentScene = currentScene.changeScene(userInput[1]);
          Player.setCurrentSceneName(currentScene.getSceneName());
          Player.changeInvItemsLocation();
          currentScene.enter(in, Player);
        } else {
          System.out.println("Incorrect input");
        }
      } else if (InputCommands.getQuitGameCommands().contains(userInput[0])) {
        System.out.println("Thanks for playing!");
        Thread.sleep(3000);
        System.exit(0);
      }
    } catch(Exception e){
      System.out.println("Invalid input");
    }
  }

  public void winCondition() throws InterruptedException {
    // For Unit Testing purpose
    if (disableIntroduction) {
      if (reachedTree) {
        winGame.printWinMessage();
      }
      reachedTree = (currentScene == aTree);
    }
    // Not unit testing mode
    else {
      if (currentScene == aTree) {
        if (Player.getNumItemsPlayerHas() >= Player.TOTAL_NUM_ITEMS_TO_FINISH_GAME) {
          winGame.printWinMessage();
        }
      }
    }
  }

  Thread thread2 = new Thread(() -> {
    try {
      Thread.sleep(1500);
      while(!SlenderMan.isGameDone){
        SimplePlayer player = new SimplePlayer("Paranormal_Lullaby.mp3");
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("Thread was interrupted");
    }

  });

}
