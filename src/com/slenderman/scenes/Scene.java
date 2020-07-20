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
  protected Scene sceneToTheNorth;
  protected Scene sceneToTheSouth;
  protected Scene sceneToTheEast;
  protected Scene sceneToTheWest;
  protected String description;
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_GREEN = "\u001B[32m";


  protected ArrayList<String> itemsInScene;

  public Scene(
    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    this.sceneToTheNorth = sceneToTheNorth;
    this.sceneToTheSouth = sceneToTheSouth;
    this.sceneToTheEast = sceneToTheEast;
    this.sceneToTheWest = sceneToTheWest;
  }

  public Scene(){};

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  //TODO: write a method that adds only 1 item to itemsInScene

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  /**
   * method enter that is used in every class and overwritten
   */
  public void enter(){

  }

  public void setItemsInScene(ArrayList<String> itemsInScene) {
    this.itemsInScene = itemsInScene;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setSceneToTheNorth(Scene sceneToTheNorth) {
    this.sceneToTheNorth = sceneToTheNorth;
  }

  public void setSceneToTheSouth(Scene sceneToTheSouth) {
    this.sceneToTheSouth = sceneToTheSouth;
  }

  public void setSceneToTheEast(Scene sceneToTheEast) {
    this.sceneToTheEast = sceneToTheEast;
  }

  public void setSceneToTheWest(Scene sceneToTheWest) {
    this.sceneToTheWest = sceneToTheWest;
  }


  // GET METHODS

  public ArrayList<String> getItemsInScene() {
    return itemsInScene;
  }

  public String getDescription() {
    return description;
  }

  public Scene getSceneToTheNorth() {
    return sceneToTheNorth;
  }

  public Scene getSceneToTheWest() {

    System.out.println("returning west");
    return sceneToTheWest;
  }

  public Scene getSceneToTheEast() {
    return sceneToTheEast;
  }

  public Scene getSceneToTheSouth() {
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



