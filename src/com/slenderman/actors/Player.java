package com.slenderman.actors;

import com.slenderman.scenes.Scene;
import com.slenderman.scenes.Shed;

import java.util.*;

public class Player {
  private String state = "alive";
  public Scene currentScene;

  private List<Item> inventory = new ArrayList<>();


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void addItemToInventory(Item... items) {
    try {
      inventory.addAll(Arrays.asList(items));
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void dropItemFromInventory(Item item) {
    Item returnableItem;

    if (inventory.contains(item)) {
      item.setCurrentScene(this.currentScene);

      int indexOfItem = inventory.indexOf(item);
      returnableItem = inventory.get(indexOfItem);

      inventory.remove(indexOfItem);

      System.out.printf("You dropped a %s from your inventory.\n",
                        returnableItem.getItemName());
    } else {
      System.out.println("It doesn't look like you have that item in your " +
                         "inventory.\n");
    }
  }

  /**
   * Changes the currentScene field for ALL items in inventory to Player's
   * current scene location
   */
  public void changeInvItemsLocation() {
    inventory.forEach(item -> item.setCurrentScene(this.currentScene));
  }

  /**
   * Changes the currentScene field for ALL items in inventory to sceneName
   * @param sceneName string representation of the scene i.e. "pond",
   *                  "forest", etc.
   */
  public void changeInvItemsLocation(Scene sceneName) {
    inventory.forEach(item -> item.setCurrentScene(sceneName));
  }



  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS
  public void setState(String state) {
    this.state = state;
  }

  public void setInventory(List<Item> inventory) {
    this.inventory = inventory;
  }

  public void setCurrentScene(Scene currentScene) {
    this.currentScene = currentScene;
  }

  // GET METHODS
  public String getState() {
    return state;
  }

  public List<Item> getInventory() {
    return Collections.unmodifiableList(inventory);
  }

  public Scene getCurrentScene() {
    return currentScene;
  }

}
