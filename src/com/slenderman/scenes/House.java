package com.slenderman.scenes;

import java.util.ArrayList;
import java.util.Arrays;

public class House extends Scene {
  // String sceneToTheNorth = "none";
  // String sceneToTheSouth = "cave";
  // String sceneToTheEast = "outhouse";
  // String sceneToTheWest = "forest";

  public String introduction;

  protected ArrayList<String> defaultItems = new ArrayList<>(Arrays.asList(
    "lockbox", "lighter"));


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public House(String sceneToTheNorth, String sceneToTheSouth,
               String sceneToTheEast, String sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
  }

  public House(String sceneToTheNorth, String sceneToTheSouth,
               String sceneToTheEast, String sceneToTheWest,
               boolean useDefaultItems) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    if (useDefaultItems == true) {
      setItemsInScene(defaultItems);
    }
  }


  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  /**
   * Overloaded method from the abstract base class Scene
   *
   */
  // public void setItemsInScene() {
  //   itemsInScene.add("lockbox");
  //   itemsInScene.add("lighter");
  // }


  @Override public String toString() {
    return "House{" +
           "sceneToTheNorth='" + sceneToTheNorth + '\'' +
           ", sceneToTheSouth='" + sceneToTheSouth + '\'' +
           ", sceneToTheEast='" + sceneToTheEast + '\'' +
           ", sceneToTheWest='" + sceneToTheWest + '\'' +
           ", description='" + description + '\'' +
           ", itemsInScene=" + itemsInScene +
           ", introduction='" + introduction + '\'' +
           ", itemsInScene=" + getItemsInScene() +
           ", description='" + getDescription() + '\'' +
           ", sceneToTheNorth='" + getSceneToTheNorth() + '\'' +
           ", sceneToTheWest='" + getSceneToTheWest() + '\'' +
           ", sceneToTheEast='" + getSceneToTheEast() + '\'' +
           ", sceneToTheSouth='" + getSceneToTheSouth() + '\'' +
           '}';
  }
}
