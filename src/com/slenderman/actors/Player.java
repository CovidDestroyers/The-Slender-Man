package com.slenderman.actors;

import com.slenderman.scenes.Scene;

import java.util.*;

public class Player {
  private String state = "alive";
  private String currentSceneName = "forest";

  private List<Item> inventory = new ArrayList<>();
  private Item Watch = new Item("watch", "forest", "timer");

  private Item Key = new Item("key", "forest", "unlock lockbox");


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Player() {
    addItemToInventory(Watch, Key);
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
      item.setCurrentScene(this.currentSceneName);
    }
  }

  public void dropItemFromInventory(Item item) {
    Item returnableItem;

    if (inventory.contains(item)) {
      item.setCurrentScene(this.currentSceneName);

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
    inventory.forEach(item -> item.setCurrentScene(this.currentSceneName));
  }

  /**
   * Changes the currentScene field for ALL items in inventory to sceneName
   * @param sceneName string representation of the scene i.e. "pond",
   *                  "forest", etc.
   */
  public void changeInvItemsLocation(String sceneName) {
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

  public void setCurrentSceneName(String currentSceneName) {
    this.currentSceneName = currentSceneName;
  }

  // GET METHODS
  public String getState() {
    return state;
  }

  public Collection<Item> getInventory() {
    return Collections.unmodifiableCollection(inventory);
  }

  public String getCurrentSceneName() {
    return currentSceneName;
  }

}
