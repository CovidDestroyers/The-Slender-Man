package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class House extends Scene {
  private String introduction;
  /**
  private Item Lockbox = new Item("lockbox", "house", "hold lighter", "house"
    , true, "key", "unlocks lockbox", "lighter");

  private Item Lighter = new Item("lighter", "house", "light torch", "house",
    true, "lockbox", "holds lighter", "none");

  private ArrayList<Item> defaultItems = new ArrayList<>(Arrays.asList(
    Lockbox, Lighter));
  */


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  //default constructor
  public House(){}

  public House(Scene sceneToTheNorth, Scene sceneToTheSouth,
               Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

  }

  public House(Scene sceneToTheNorth, Scene sceneToTheSouth,
               Scene sceneToTheEast, Scene sceneToTheWest,
               boolean useDefaultItems) {
    this(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    if (useDefaultItems) {
      //setDefaultItems(defaultItems);
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

  // SET METHODS

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }
  /**
  public Item getLockbox() {
    return Lockbox;
  }

  public void setLockbox(Item lockbox) {
    Lockbox = lockbox;
  }

  public Item getLighter() {
    return Lighter;
  }

  public void setLighter(Item lighter) {
    Lighter = lighter;
  }

  public ArrayList<Item> getDefaultItems() {
    return defaultItems;
  }

  public void setDefaultItems(ArrayList<Item> defaultItems) {
    this.defaultItems = defaultItems;
  }

  /**
   * Overloaded method from the abstract base class Scene
   *
   */
  @Override
  public void enter() {

  }

  /**
  @Override
  public String toString() {
    return "House{" + "introduction='" + introduction + '\'' +
           ", defaultItems=" + defaultItems + ", Lockbox=" + Lockbox +
           ", Lighter=" + Lighter + "} " + super.toString();
  }
  */
}
