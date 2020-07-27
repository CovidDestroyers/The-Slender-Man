package com.slenderman.game;

import com.slenderman.scenes.*;
import com.slenderman.actors.Player;
import com.slenderman.tools.LoseGameTimer;

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

  // For Unit Testing Purpose //
  private boolean disableIntroduction = false;
  private boolean reachedTree = false;
  /////////////////////////////

  private Scene currentScene;


  private Player player;
  static Scanner in;

  private Scene aTree;
  private Map<Scene, Map> totalMap = new HashMap<>();
  private Map<String, Scene> forestMap = new HashMap<>();
  private Map<String, Scene> houseMap = new HashMap<>();
  private Map<String, Scene> shedMap = new HashMap<>();
  private Map<String, Scene> abandonedcarMap = new HashMap<>();
  private Map<String, Scene> outhouseMap = new HashMap<>();
  private Map<String, Scene> caveMap = new HashMap<>();
  private Map<String, Scene> pondMap = new HashMap<>();
  private Map<String, Scene> fieldMap = new HashMap<>();



  public Game() {

    setScanner();

    Scene aForest = new Forest(player);
    Scene aShed = new Shed(player);
    Scene aAbandonedCar = new AbandonedCar(player);
    Scene aField = new Field(player);
    aTree = new Tree(player);
    Scene aPond = new Pond(player);
    Scene aCave = new Cave(player);
    Scene aOutHouse = new OutHouse(player);
    Scene aHouse = new House(player);

    setCurrentScene(aForest);
    player = new Player(aForest);
    //{forestMap: {"south": aShed, "east":aHouse},
    // houseMap: {"south":aCave, "east":aAbandonedhouse},
    // shedMap: {"east":aCave},
    // abandonedcarMap:{"east":aOutHouse},
    // outhouseMap : {"south" : aPond},
    // caveMap : {"east" : aPond},
    // pondMap : {"east" : aField},
    // fieldMap : {"east" : aTree}}
    forestMap.put("south", aShed);
    forestMap.put("east", aHouse);

    houseMap.put("south", aCave);
    houseMap.put("east", aAbandonedCar);

    shedMap.put("east", aCave);

    abandonedcarMap.put("east", aOutHouse);

    outhouseMap.put("south", aPond);

    caveMap.put("east", aPond);

    pondMap.put("east", aField);

    fieldMap.put("east", aTree);


    totalMap.put(aForest, forestMap);
    totalMap.put(aForest, houseMap);
    totalMap.put(aForest, houseMap);
    totalMap.put(aForest, houseMap);
    totalMap.put(aForest, houseMap);
    totalMap.put(aForest, houseMap);
    totalMap.put(aForest, houseMap);
    totalMap.put(aForest, houseMap);


  }



  public void start() throws Exception {
    String userText = "";

    new LoseGameTimer(10);

    // For Unit Testing purpose
    if (!disableIntroduction) {
      Introduction.playIntro();
    }

    setScanner();
    currentScene.enter();

    while (true) {
      userText = in.nextLine().toLowerCase().trim();

      if (userText.equals("quit")) {
        System.out.println("Goodbye!");
        break;
      }

      if (userText.startsWith("go ")) {

        currentScene = currentScene.changeScene(Directions.valueOf(userText.substring(3)));

        player.setCurrentScene(currentScene);
        player.changeInvItemsLocation();

        currentScene.enter();


      }

      else {
        System.out.println("Unknown command '" + userText + "'.  Try go/take/quit.\n");
      }

      // For Unit Testing purpose
      if (disableIntroduction) {
        reachedTree = (currentScene.getSceneName().equals(aTree.getSceneName()));

        if (reachedTree) {
          winMessage();
        }


      }

    }
  }

  /**Scanner */

  private void setScanner(){
    in = new Scanner(System.in);
  }

  public static Scanner getScanner(){
    return in;
  }

  public static String playerChoice(Scanner choice) {
    return choice.nextLine();
  }

  public static void winMessage() throws Exception {
    Thread.sleep(2000);
    System.out.println("You have killed SlenderMan\n");
    Thread.sleep(5000);
    System.out.println("You Win!");
    System.out.println("Thanks for playing!");
    Thread.sleep(5000);
    System.exit(0);
  }

 /**
  * For Unit Testing purpose
  * */
   public void setCurrentScene(Scene currentScene) {
     this.currentScene = currentScene;
     player.setCurrentScene(currentScene);
   }
  public Scene getCurrentScene() {
    return currentScene;
  }
  public void setDisableIntroduction(boolean disableIntroduction) {
    this.disableIntroduction = disableIntroduction;
  }
}
