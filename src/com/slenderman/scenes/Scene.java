package com.slenderman.scenes;

import java.util.ArrayList;

/**
 *  The Scene Interface is used to ensure classes such as Hut and
 *  Cave, implement common methods where the details of each
 *  implementation is only relevant to the implementing class.
 *
 *  If a method needs to have a common implementation across classes then you
 *  can either change Scene to an abstract class or create a new abstract
 *  class that implements Scene.
 */
public abstract class Scene {
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_GREEN = "\u001B[32m";

  protected Scene northScene;
  protected Scene eastScene;
  protected Scene southScene;
  protected Scene westScene;

  protected String sceneToTheNorth;
  protected String sceneToTheSouth;
  protected String sceneToTheEast;
  protected String sceneToTheWest;
  protected String description;

  protected ArrayList<String> itemsInScene;

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Scene(
    String sceneToTheNorth, String sceneToTheSouth,
    String sceneToTheEast, String sceneToTheWest) {
    this.sceneToTheNorth = sceneToTheNorth;
    this.sceneToTheSouth = sceneToTheSouth;
    this.sceneToTheEast = sceneToTheEast;
    this.sceneToTheWest = sceneToTheWest;
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  // TODO: write a method that adds only 1 item to itemsInScene

  public void connectEast(Scene otherScene){
    eastScene = otherScene;
    otherScene.westScene = this;
  };

  public void connectSouth(Scene otherScene){
    southScene = otherScene;
    otherScene.northScene = this;
  };

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS
  public void setItemsInScene(ArrayList<String> itemsInScene) {
    this.itemsInScene = itemsInScene;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setSceneToTheNorth(String sceneToTheNorth) {
    this.sceneToTheNorth = sceneToTheNorth;
  }

  public void setSceneToTheSouth(String sceneToTheSouth) {
    this.sceneToTheSouth = sceneToTheSouth;
  }

  public void setSceneToTheEast(String sceneToTheEast) {
    this.sceneToTheEast = sceneToTheEast;
  }

  public void setSceneToTheWest(String sceneToTheWest) {
    this.sceneToTheWest = sceneToTheWest;
  }


  // GET METHODS

  public ArrayList<String> getItemsInScene() {
    return itemsInScene;
  }

  public String getDescription() {
    return description;
  }

  public String getSceneToTheNorth() {
    return sceneToTheNorth;
  }

  public String getSceneToTheWest() {
    return sceneToTheWest;
  }

  public String getSceneToTheEast() {
    return sceneToTheEast;
  }

  public String getSceneToTheSouth() {
    return sceneToTheSouth;
  }


  @Override public String toString() {
    return "Scene{" +
           "sceneToTheNorth='" + sceneToTheNorth + '\'' +
           ", sceneToTheSouth='" + sceneToTheSouth + '\'' +
           ", sceneToTheEast='" + sceneToTheEast + '\'' +
           ", sceneToTheWest='" + sceneToTheWest + '\'' +
           '}';
  }
}



