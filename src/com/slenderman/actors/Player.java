package com.slenderman.actors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Player {
  public final int TOTAL_NUM_ITEMS_TO_FINISH_GAME = 6;

  private String state = "alive";
  private String currentSceneName = "forest";

  private List<Item> inventory = new ArrayList<>();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Player() {
    ArrayList<Item> defaultInvItems = ItemDirector.getItemsForScene("forest");
    addItemToInventory(defaultInvItems);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void addItemToInventory(Item... items) {
    try {
      inventory.addAll(Arrays.asList(items));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void addItemToInventory(ArrayList<Item> items) {
    try {
      inventory.addAll(items);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void dropItemFromInventory(Item item) {
    Item returnableItem;

    if (inventory.contains(item)) {
      item.setCurrentScene(this.currentSceneName);

      int indexOfItem = inventory.indexOf(item);
      returnableItem = inventory.get(indexOfItem);

      inventory.remove(indexOfItem);

      System.out.printf("You dropped the %s from your inventory.\n",
                        returnableItem.getItemName());
    } else {
      System.out.println("It doesn't look like you have that item in your inventory.\n");
    }
  }

  /**
   * Changes the currentScene field for ALL items in inventory to Player's current scene location
   */
  public void changeInvItemsLocation() {
    inventory.forEach(item -> item.setCurrentScene(this.currentSceneName));
  }

  /**
   * Changes the currentScene field for ALL items in inventory to sceneName
   *
   * @param sceneName string representation of the scene i.e. "pond", "forest", etc.
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

  public int getNumItemsPlayerHas(){
    return getInventory().size();
  }

  public String getCurrentSceneName() {
    return currentSceneName;
  }
}
