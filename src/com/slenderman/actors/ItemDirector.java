package com.slenderman.actors;

import java.util.ArrayList;
import java.util.List;

public class ItemDirector {

  private static final ItemBuilder itemBuilder = new ItemBuilder();

  private static final List<Item> allItems = itemBuilder.buildAllItems();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  private ItemDirector() {}

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  public static ArrayList<Item> getItemsForScene(String sceneName) {
    String name = sceneName.trim().toLowerCase();
    ArrayList<Item> itemsInScene = new ArrayList<>();

    for (Item item : allItems) {
      String itemSceneName = item.getCurrentScene();

      if (name.equals(itemSceneName)) {
        itemsInScene.add(item);
      }
    }

    return itemsInScene;
  }

  // TODO: Write a method that searches for only 1 item
}
