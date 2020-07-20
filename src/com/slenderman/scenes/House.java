package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class House extends Scene {
  // String sceneToTheNorth = "none";
  // String sceneToTheSouth = "cave";
  // String sceneToTheEast = "outhouse";
  // String sceneToTheWest = "forest";

  public String introduction;

  private ArrayList<String> defaultItems = new ArrayList<>(Arrays.asList(
    "lockbox", "lighter"));

  // TODO: instantiate the lighter and lockbox here
  private Item lighter;



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public House(Scene sceneToTheNorth, Scene sceneToTheSouth,
               Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

  }

  public House(Scene sceneToTheNorth, Scene sceneToTheSouth,
               Scene sceneToTheEast, Scene sceneToTheWest,
               boolean useDefaultItems) {
    //super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    if (useDefaultItems) {
      setItemsInScene(defaultItems);
    }
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  public void unlockLockBox(Player player) {
    if (playerHasKey(player)) {
      System.out.println("You have opened the lockbox! You are awarded a " +
                         "lighter. May it light your path in times of " +
                         "darkness.\n");
    }

  }
  // TODO: search through player's inventory and see if they have the correct
  //  item
  public Boolean playerHasKey(Player player) {
    Collection<Item> playerInventory = player.getInventory();

    boolean hasItem = false;
    for (Item item : playerInventory) {
      if (item.getItemName().equals("key")) {
        hasItem = true;
        break;
      }
    }

    return hasItem;
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


  @Override
  public String toString() {
    return "House{" + "ANSI_BLUE='" + ANSI_BLUE + '\'' + ", ANSI_WHITE='" +
           ANSI_WHITE + '\'' + ", ANSI_RED='" + ANSI_RED + '\'' +
           ", ANSI_BLACK='" + ANSI_BLACK + '\'' + ", ANSI_GREEN='" +
           ANSI_GREEN + '\'' + ", sceneToTheNorth=" + sceneToTheNorth +
           ", sceneToTheSouth=" + sceneToTheSouth + ", sceneToTheEast=" +
           sceneToTheEast + ", sceneToTheWest=" + sceneToTheWest +
           ", description='" + description + '\'' + ", itemsInScene=" +
           itemsInScene + ", introduction='" + introduction + '\'' +
           ", defaultItems=" + defaultItems + ", lighter=" + lighter +
           ", itemsInScene=" + getItemsInScene() + ", description='" +
           getDescription() + '\'' + ", sceneToTheNorth=" +
           getSceneToTheNorth() + ", sceneToTheWest=" + getSceneToTheWest() +
           ", sceneToTheEast=" + getSceneToTheEast() + ", sceneToTheSouth=" +
           getSceneToTheSouth() + '}';
  }
}
