package com.slenderman.actors;

import com.slenderman.scenes.Scene;

import java.util.*;

public class Player {
  private String state = "alive";

  private List<Item> inventory = new ArrayList<>();

  public Scene currentScene;


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Player(Scene currentScene) {

  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  // TODO: this needs to be tested
  public void addItemToInventory(Item... items) {
    inventory.addAll(Arrays.asList(items));
    for (Item item : items) {
      System.out.printf("What a prize! You have added a %s to your inventory.\n",
        item.getItemName());
    }
  }

  public void dropItemFromInventory(Item item) {
    Item returnableItem;
    if (inventory.contains(item)) {

      item.setItemScene(this.currentScene);
      currentScene.addItem(item);

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
   * Changes the currentScene field for all items in inventory to Player's
   * current scene location
   */
  public void changeInvItemsLocation() {
    inventory.forEach(item -> item.setItemScene(this.currentScene));
  }

  /**
   * Changes the currentScene field for all items in inventory to sceneName
   * @param sceneName string representation of the scene i.e. "pond",
   *                  "forest", etc.
   */
  public void changeInvItemsLocation(Scene sceneName) {
    inventory.forEach(item -> item.setItemScene(sceneName));
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

  public Collection<Item> getInventory() {
    return Collections.unmodifiableCollection(inventory);
  }

  public Scene getCurrentScene() {
    return currentScene;
  }

}
