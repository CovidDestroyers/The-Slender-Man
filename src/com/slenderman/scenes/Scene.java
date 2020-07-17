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
  protected String sceneToTheNorth;
  protected String sceneToTheSouth;
  protected String sceneToTheEast;
  protected String sceneToTheWest;
  protected String description;

  protected ArrayList<String> itemsInScene;

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

  //TODO: write a method that adds only 1 item to itemsInScene

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



